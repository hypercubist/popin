package io.summer.popin.domain.reservation.controller;

import io.summer.popin.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/reservation")
@Controller
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{reservationNo}")
    public String reservation(@PathVariable Integer reservationNo){

        reservationService.getReservation(reservationNo);

        return "reservation";
    }
}
