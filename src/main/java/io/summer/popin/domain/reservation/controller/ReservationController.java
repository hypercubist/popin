package io.summer.popin.domain.reservation.controller;

import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dto.KakaopayApproveResponseDTO;
import io.summer.popin.domain.reservation.dto.KakaopayReadyResponseDTO;
import io.summer.popin.domain.reservation.service.PaymentService;
import io.summer.popin.domain.reservation.service.ReservationService;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        log.info("RESDATA1 = {}", reservationRequestDTO);
        KakaopayReadyResponseDTO readyDTO = paymentService.readyPayment(reservationRequestDTO);
        model.addAttribute("readyDTO", readyDTO);

        return "redirect:"+readyDTO.getNext_redirect_pc_url();
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(@RequestParam("pg_token") String pgToken, @SessionAttribute("reservationData") ReservationRequestDTO reservationRequestDTO, @SessionAttribute("readyDTO") KakaopayReadyResponseDTO readyDTO){

        KakaopayApproveResponseDTO approveDTO = paymentService.approvePayment(reservationRequestDTO, readyDTO, pgToken);
        reservationRequestDTO.setOrderId(approveDTO.getPartner_order_id());
        log.info("RESDATA2 = {}", reservationRequestDTO);
        ReservationVO reservationVO = reservationService.insertReservation(reservationRequestDTO);
        Long reservationNo =reservationVO.getNo();
        return "redirect:/reservation/"+reservationNo; //예약확인 페이지로 이동해야함
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
    public String reservation(@PathVariable Integer reservationNo){

        reservationService.getReservation(reservationNo);


        return "reservation";
    }
}
