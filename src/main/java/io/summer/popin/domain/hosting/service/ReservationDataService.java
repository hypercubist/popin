package io.summer.popin.domain.hosting.service;

import io.summer.popin.domain.hosting.dto.ReservationCountResponseDTO;

public interface ReservationDataService {

    public ReservationCountResponseDTO getReservationCount(Long memberNo);
}
