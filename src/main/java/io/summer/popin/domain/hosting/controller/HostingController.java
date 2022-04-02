package io.summer.popin.domain.hosting.controller;

import io.summer.popin.domain.hosting.dto.ReservationCountResponseDTO;
import io.summer.popin.domain.hosting.service.ReservationDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/hosting")
@Controller
public class HostingController {

    private final ReservationDataService reservationDataService;


    @GetMapping("/{memberNo}/reservation-management")   //예약관리 페이지
    public String hosting(@PathVariable("memberNo") Long memberNo, Model model) {

        ReservationCountResponseDTO reservationCountResponseDTO  = reservationDataService.getReservationCount(memberNo);

        return "hosting";
    }
}
