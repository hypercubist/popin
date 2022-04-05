package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.vo.ReservationVO;

public interface ReservationService {

    public ReservationVO getReservation(int reservationNo);

    public ReservationVO insertReservation(ReservationRequestDTO reservationRequestDTO);

}
