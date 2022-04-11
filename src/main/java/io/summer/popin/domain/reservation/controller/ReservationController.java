package io.summer.popin.domain.reservation.controller;

import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dto.KakaopayApproveResponseDTO;
import io.summer.popin.domain.reservation.dto.KakaopayReadyResponseDTO;
import io.summer.popin.domain.reservation.dto.ReservationResponseDTO;
import io.summer.popin.domain.reservation.service.PaymentService;
import io.summer.popin.domain.reservation.service.ReservationService;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@SessionAttributes({"reservationData","readyDTO"})
@RequestMapping("/reservation")
@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final PaymentService paymentService;

    @GetMapping("/payment")
    public String requestReservation(){

        return "reservation-payment";
    }

    @PostMapping("/payment")
    public String requestPayment(@ModelAttribute("reservationData") ReservationRequestDTO reservationRequestDTO, Model model){

        reservationRequestDTO.setGuestNo(4L); //guest는 세션에서 받아오기
        KakaopayReadyResponseDTO readyDTO = paymentService.readyPayment(reservationRequestDTO);
        model.addAttribute("readyDTO", readyDTO);

        return "redirect:"+readyDTO.getNext_redirect_pc_url();
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(@RequestParam("pg_token") String pgToken,
                                 @ModelAttribute("reservationData") ReservationRequestDTO reservationRequestDTO,
                                 @SessionAttribute("readyDTO") KakaopayReadyResponseDTO readyDTO,
                                 SessionStatus sessionStatus){

        KakaopayApproveResponseDTO approveDTO = paymentService.approvePayment(reservationRequestDTO, readyDTO, pgToken);
        reservationRequestDTO.setOrderId(approveDTO.getPartner_order_id());
        ReservationVO reservationVO = reservationService.insertReservation(reservationRequestDTO);
        Long reservationNo =reservationVO.getNo();
        sessionStatus.setComplete();
        return "redirect:/reservation/"+reservationNo;
    }

    @GetMapping("/payment/cancel")
    public String paymentCancel(){

        return "redirect:/";
    }

    @GetMapping("/payment/fail")
    public String paymentFail(){

        return "redirect:/";
    }

    @GetMapping("/{reservationNo}")
    public String reservation(@PathVariable Long reservationNo, Model model){
        ReservationResponseDTO reservationDetail = reservationService.getReservationDetail(reservationNo);
        List<String> imageUrls = reservationService.getImageUrls(reservationNo);
        model.addAttribute("reservation", reservationDetail);
        model.addAttribute("imageUrls", imageUrls);
        log.info("RESERVATION = {}", reservationDetail);
        log.info("URLS = {}", imageUrls);

        return "reservation-detail";
    }

    @GetMapping("/{reservationNo}/update")
    public String reservationUpdate(@PathVariable Long reservationNo) {



        return "reservation-update";
    }

    @GetMapping("/guest")
    public String reservations_guest(@SessionAttribute("loginMember")SessionUserDTO loginMember, Model model) {

        List<ReservationResponseDTO> reservationsForGuest = reservationService.getReservationsForGuest(loginMember);
        model.addAttribute("reservations", reservationsForGuest);
        log.info("LOGIN = {}", loginMember);
        log.info("RESERVATIONS = {}", reservationsForGuest);
        return "reservation-for-guest";
    }

}
