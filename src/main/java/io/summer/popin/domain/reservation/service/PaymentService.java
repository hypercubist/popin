package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dto.KakaopayReadyResponseDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public interface PaymentService {

    KakaopayReadyResponseDTO readyPayment(int guestNo, int totalPrice);

    void approvePayment();

    default String createOrderId(){
        String uuid = UUID.randomUUID().toString();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return today + "_" + uuid;
    }
}
