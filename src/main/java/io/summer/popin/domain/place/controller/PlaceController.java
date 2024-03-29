package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.member.service.MemberService;
import io.summer.popin.domain.model.ResourceKind;
import io.summer.popin.domain.place.dto.*;
import io.summer.popin.domain.place.service.PlaceService;
import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.global.dto.UrlResourceDTO;
import io.summer.popin.global.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@SessionAttributes("searchDTO")
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;
    private final MemberService memberService;
    private final AwsS3Service awsS3Service;

    @ModelAttribute("searchDTO")
    public SearchDTO test(){
        return new SearchDTO();
    }

    @GetMapping
    public String myPlaces(Model model, @SessionAttribute("loginMember")SessionUserDTO loginMember) {

        Long hostNo = loginMember.getNo();

        model.addAttribute("myPlaces", placeService.getPlaces(hostNo));
        model.addAttribute("myPlacesCount", placeService.getMyPlacesCount(hostNo));
        return "my-places";
    }

    @GetMapping("/{placeNo}")
    public String placeDetail(@PathVariable Long placeNo,
                              @ModelAttribute("reservationData") ReservationRequestDTO requestDTO,
                              @ModelAttribute("searchDTO") SearchDTO searchDTO,
                              Model model) {

        PlaceDetailResponseDTO placeDetail = placeService.getPlaceDetail(placeNo);
        model.addAttribute("place", placeService.getPlaceDetail(placeNo));
        model.addAttribute("hostProfileUrl", memberService.getProfileImageUrl(placeDetail.getHostNo()));
        model.addAttribute("imageUrls", placeService.getImageUrls(placeNo));
        model.addAttribute("thumbnailUrl", placeService.getThumbnailUrl(placeNo));
        model.addAttribute("reservatedDates", placeService.getReservatedDates(placeNo));
        model.addAttribute("reviews", placeService.getReviews(placeNo));
        return "html/place-detail";
    }

    @PostMapping("/{placeNo}")
    public String reservationPage(@PathVariable Long placeNo, @ModelAttribute("reservationRequest") ReservationRequestDTO reservationRequestDTO, RedirectAttributes rttr) {

        rttr.addFlashAttribute("place", placeService.getPlaceDetail(placeNo));
        rttr.addFlashAttribute("imageUrls", placeService.getImageUrls(placeNo));
        rttr.addFlashAttribute("reservationData", reservationRequestDTO);
        return "redirect:/reservation/payment";
    }

    @GetMapping("/register")
    public String placeRegisterForm(@ModelAttribute("registerForm") PlaceRegisterDTO registerDTO, Model model) {

        model.addAttribute("placeKinds", placeService.getPlaceKinds());
        model.addAttribute("kakaoMapsSource", placeService.getKakaoMapsSource());

        return "html/place-register";
    }

    @PostMapping("/register")
    public String placeRegister(@Validated @ModelAttribute("registerForm") PlaceRegisterDTO registerDTO,
                                @RequestParam("placeThumbnail") List<MultipartFile> placeThumbnail,
                                @RequestParam("imageFiles") List<MultipartFile> imageFiles, UrlResourceDTO urlResourceDTO,
                                BindingResult bindingResult,
                                Model model, @SessionAttribute("loginMember")SessionUserDTO loginMember) {
        model.addAttribute("placeKinds", placeService.getPlaceKinds());
        model.addAttribute("kakaoMapsSource", placeService.getKakaoMapsSource());
        log.info("PLACEREGISTERDTO = {}", registerDTO );
        KakaoLocalRoadAddressDTO roadAddress = placeService.getRoadAddress(registerDTO.getCoordX(), registerDTO.getCoordY());

        registerDTO.setRegion1Depth(roadAddress.getRegion_1depth_name());
        registerDTO.setRegion2Depth(roadAddress.getRegion_2depth_name());
        registerDTO.setRegion3Depth(roadAddress.getRegion_3depth_name());
        registerDTO.setRoadName(roadAddress.getRoad_name());
        registerDTO.setMainBuildingNo(roadAddress.getMain_building_no());
        registerDTO.setSubBuildingNo(roadAddress.getSub_building_no());
        registerDTO.setHostNo(loginMember.getNo());

        Long placeNo = placeService.registerPlace(registerDTO);
        urlResourceDTO.setPlaceNo(placeNo);
        urlResourceDTO.setKindCode(2);
        awsS3Service.uploadImage(imageFiles, urlResourceDTO);  //숙소사진들

        urlResourceDTO.setPlaceNo(placeNo);
        urlResourceDTO.setKindCode(3);
        awsS3Service.uploadImage(placeThumbnail, urlResourceDTO);  //숙소 thumbnail
        if(placeNo == null) {
            bindingResult.reject("saveFailed", "장소 등록에 실패하였습니다. 다시 시도해주세요.");
        }

        if (bindingResult.hasErrors()) {
            log.info("ERRORS-PLACE-REGISTER : {}", bindingResult);
            return "place-register";
        }
        return "redirect:/places/" + placeNo;
    }

    @GetMapping("/{placeNo}/update")
    public String placeUpdateForm(@PathVariable Long placeNo, Model model){


        return "place-update";
    }
}
