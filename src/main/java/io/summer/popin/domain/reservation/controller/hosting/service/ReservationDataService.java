package io.summer.popin.domain.reservation.controller.hosting.service;

import io.summer.popin.domain.reservation.controller.hosting.dto.ReservationCountResponseDTO;

public interface ReservationDataService {

    public ReservationCountResponseDTO getReservationCount(Long memberNo);
}
