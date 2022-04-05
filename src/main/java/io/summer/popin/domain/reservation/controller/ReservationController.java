package io.summer.popin.domain.reservation.controller;

import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dto.KakaopayReadyResponseDTO;
import io.summer.popin.domain.reservation.service.PaymentService;
import io.summer.popin.domain.reservation.service.ReservationService;
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

        KakaopayReadyResponseDTO readyDTO = paymentService.readyPayment(4, reservationRequestDTO.getTotalPrice());//guest는 세션에서 받아오기
        model.addAttribute("readyDTO", readyDTO);

        return "redirect:"+readyDTO.getNext_redirect_pc_url();
    }

    @GetMapping("/payment/success")
    public String paymentSuccess(@RequestParam("pg_token") String pgToken, @SessionAttribute("reservationData") ReservationRequestDTO reservationRequestDTO, @SessionAttribute("readyDTO") KakaopayReadyResponseDTO readyDTO){

        log.info("READY = {}", readyDTO);
        log.info("RESERVATION = {}", reservationRequestDTO);
        log.info("PG-TOKEN = {}", pgToken);
        return "redirect:/"; //예약확인 페이지로 이동해야함
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
        //여기서 부터 다시 시작
        //세션에 넣은 데이터로 결제승인 요청하고 승인 완료 시 예약 insert
        //세션 삭제

        return "reservation";
    }
}
