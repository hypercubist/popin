package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.place.dto.*;
import io.summer.popin.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/register")
    public String placeRegisterForm(@ModelAttribute("registerForm") PlaceRegisterDTO registerDTO, Model model){

        List<PlaceKindDTO> placeKinds = placeService.getPlaceKinds();
        model.addAttribute("placeKinds", placeKinds);
        model.addAttribute("kakaoMapsSource", placeService.getKakaoMapsSource());

        return "place-register";
    }

    @PostMapping("/register")
    public String placeRegister(@Validated @ModelAttribute("registerForm") PlaceRegisterDTO registerDTO,
                                BindingResult bindingResult){

        //폼데이터검증
        //좌표값으로 상세주소 가져오기  addressDTO
        //주소값을 레지스터dto에 넣기
        //db에 저장
        //등록한 장소 리스트 페이지로 리다이렉트
        
        
        log.info("FORM = {}", registerDTO);
        return "place-register";
    }

    @GetMapping("/{placeNo}")
    public String placeDetail(@PathVariable Integer placeNo, @ModelAttribute("reservationData") ReservationRequestDTO requestDTO, Model model){

        LocalDateTime checkinDate = LocalDateTime.of(2022, 4, 8,0,0);
        LocalDateTime checkoutDate = LocalDateTime.of(2022, 4, 9,0,0); //장소 리스트에서 모델로 받아올 정보임
        TempSearchRequestDTO searchDTO = new TempSearchRequestDTO(checkinDate, checkoutDate);

        model.addAttribute("place", placeService.getPlaceDetail(placeNo));
        model.addAttribute("imageUrls", placeService.getImageUrls(placeNo));
        model.addAttribute("searchDTO", searchDTO);

        return "place-detail";
    }

    @PostMapping("/{placeNo}")
    public String reservationPage(@PathVariable Integer placeNo, @ModelAttribute("reservationRequest") ReservationRequestDTO reservationRequestDTO, RedirectAttributes rttr){

        rttr.addFlashAttribute("place", placeService.getPlaceDetail(placeNo));
        rttr.addFlashAttribute("imageUrls", placeService.getImageUrls(placeNo));
        rttr.addFlashAttribute("reservationData", reservationRequestDTO);
        return "redirect:/reservation/payment";
    }

}
