package io.summer.popin.domain.reservation.controller;

import io.summer.popin.domain.reservation.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/payment")
@Controller
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/kakaopay")
    public void kakaopay(){

        paymentService.readyPayment();

    }
}
