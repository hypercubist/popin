package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public ReservationVO getReservation(int reservationNo) {
        return null;
    }

    @Override
    public ReservationVO insertReservation(ReservationRequestDTO reservationRequestDTO) {
        return null;
    }

}
