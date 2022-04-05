package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.place.dto.TempSearchRequestDTO;
import io.summer.popin.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
