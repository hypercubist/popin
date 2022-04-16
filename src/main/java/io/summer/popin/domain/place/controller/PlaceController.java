package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.member.dto.LoginMemberInfoDTO;
import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.place.dto.*;
import io.summer.popin.domain.place.service.PlaceService;
import io.summer.popin.domain.place.vo.PlaceVO;
import io.summer.popin.domain.reservation.vo.ReservationVO;
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

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;
    private final AwsS3Service awsS3Service;

    @GetMapping
    public String myPlaces(Model model, @SessionAttribute("loginMember")SessionUserDTO loginMember) {

        Long hostNo = loginMember.getNo();

        model.addAttribute("myPlaces", placeService.getPlaces(hostNo));
        model.addAttribute("myPlacesCount", placeService.getMyPlacesCount(hostNo));
        return "my-places";
    }

    @GetMapping("/{placeNo}")
    public String placeDetail(@PathVariable Long placeNo, @ModelAttribute("reservationData") ReservationRequestDTO requestDTO, Model model) {

        LocalDateTime checkinDate = LocalDateTime.of(2022, 4, 8, 0, 0);
        LocalDateTime checkoutDate = LocalDateTime.of(2022, 4, 9, 0, 0); //장소 리스트에서 모델로 받아올 정보임
        TempSearchRequestDTO searchDTO = new TempSearchRequestDTO(checkinDate, checkoutDate);

        model.addAttribute("place", placeService.getPlaceDetail(placeNo));
        model.addAttribute("imageUrls", placeService.getImageUrls(placeNo));
        model.addAttribute("searchDTO", searchDTO);

        return "place-detail";
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

        return "place-register";
    }

    @PostMapping("/register")
    public String placeRegister(@Validated @ModelAttribute("registerForm") PlaceRegisterDTO registerDTO, List<MultipartFile> imageFiles, UrlResourceDTO urlResourceDTO,
                                BindingResult bindingResult,
                                Model model, @SessionAttribute("loginMember")SessionUserDTO loginMember) {
        model.addAttribute("placeKinds", placeService.getPlaceKinds());
        model.addAttribute("kakaoMapsSource", placeService.getKakaoMapsSource());
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
        awsS3Service.uploadImage(imageFiles, urlResourceDTO);
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
