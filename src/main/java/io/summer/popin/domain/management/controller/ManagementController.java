package io.summer.popin.domain.management.controller;

import io.summer.popin.domain.management.dto.MemberCountDTO;
import io.summer.popin.domain.management.dto.PlaceCountDTO;
import io.summer.popin.domain.management.dto.ReservationCountDTO;
import io.summer.popin.domain.management.service.ManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/management")
@Controller
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping
    public String management(Model model) {

        MemberCountDTO memberCountDTO = managementService.getMemberCount();
        PlaceCountDTO placeCountDTO = managementService.getPlaceCount();
        ReservationCountDTO reservationCountDTO = managementService.getReservationCount();

        model.addAttribute("memberCount", memberCountDTO);
        model.addAttribute("placeCount", placeCountDTO);
        model.addAttribute("reservationCount", reservationCountDTO);

        log.info("MEMBER-COUNT : {}", memberCountDTO);
        log.info("PLACE-COUNT: {}", placeCountDTO);
        log.info("RESERVATION-COUNT: {}", reservationCountDTO);

        return "html/management";
    }
}
