package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.reservation.dto.ReservationResponseDTO;

public interface ReservationService {
    public ReservationResponseDTO getReservation(int reservationNo);
}
