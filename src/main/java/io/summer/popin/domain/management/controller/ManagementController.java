package io.summer.popin.domain.management.controller;

import io.summer.popin.domain.management.dto.MemberCountDTO;
import io.summer.popin.domain.management.dto.PlaceCountDTO;
import io.summer.popin.domain.management.dto.ReservationCountDTO;
import io.summer.popin.domain.management.service.MemberManagementService;
import io.summer.popin.domain.management.service.PlaceManagementService;
import io.summer.popin.domain.management.service.ReservationManagementService;
import io.summer.popin.global.dto.PageDTO;
import io.summer.popin.global.vo.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/management")
@Controller
public class ManagementController {

    private final MemberManagementService memberManagementService;
    private final PlaceManagementService placeManagementService;
    private final ReservationManagementService reservationManagementService;

    @GetMapping
    public String management(Model model) {

        MemberCountDTO memberCountDTO = memberManagementService.getMemberCount();
        PlaceCountDTO placeCountDTO = placeManagementService.getPlaceCount();
        ReservationCountDTO reservationCountDTO = reservationManagementService.getReservationCount();

        model.addAttribute("memberCount", memberCountDTO);
        model.addAttribute("placeCount", placeCountDTO);
        model.addAttribute("reservationCount", reservationCountDTO);

        log.info("MEMBER-COUNT : {}", memberCountDTO);
        log.info("PLACE-COUNT: {}", placeCountDTO);
        log.info("RESERVATION-COUNT: {}", reservationCountDTO);

        return "html/management";
    }

    @GetMapping("/members")
    public String memberManagement(@ModelAttribute("criteria") Criteria cri,
                                   Model model) {
        MemberCountDTO memberCountDTO = memberManagementService.getMemberCount();
        model.addAttribute("memberCount", memberCountDTO);
        model.addAttribute("memberClass", memberManagementService.getMemberClassList());
        model.addAttribute("memberList", memberManagementService.getMemberList(cri));
        model.addAttribute("page", new PageDTO(cri, memberManagementService.getSearchMemberCount(cri)));
        return "html/management-members";
    }


    @GetMapping("/places")
    public String placeManagement(Model model) {
        PlaceCountDTO placeCountDTO = placeManagementService.getPlaceCount();
        model.addAttribute("placeCount", placeCountDTO);
        model.addAttribute("placeStatus", placeManagementService.getPlaceStatusList());
        return "html/management-places";
    }

    @GetMapping("/reservations")
    public String reservationManagement(Model model) {
        ReservationCountDTO reservationCountDTO = reservationManagementService.getReservationCount();
        model.addAttribute("reservationCount", reservationCountDTO);
        model.addAttribute("reservationStatus", reservationManagementService.getReservationStatusList());
        return "html/management-reservations";
    }
}
