package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dto.ReservationResponseDTO;
import io.summer.popin.domain.reservation.vo.ReservationVO;

import java.util.List;

public interface ReservationService {

    ReservationResponseDTO getReservationDetail(int reservationNo);

    ReservationVO insertReservation(ReservationRequestDTO reservationRequestDTO);

    List<String> getImageUrls(int reservationNo);

}
