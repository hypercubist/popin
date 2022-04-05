package io.summer.popin.domain.reservation.controller;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.service.ReservationService;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reservation")
@Controller
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public String requestReservation(){

        return "reservation-request";
    }

    @PostMapping
    public String requestPayment(@ModelAttribute("reservationRequest") ReservationRequestDTO reservationRequestDTO, RedirectAttributes rttr){

        ReservationVO reservation = reservationService.insertReservation(reservationRequestDTO);

        return "redirect:/payment/kakaopay";
    }

    @GetMapping("/{reservationNo}")
    public String reservation(@PathVariable Integer reservationNo){

        reservationService.getReservation(reservationNo);

        return "reservation";
    }
}
