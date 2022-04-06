package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dao.ReservationMapper;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;

    @Override
    public ReservationVO getReservation(int reservationNo) {
        return reservationMapper.findOneByNo(reservationNo);
    }

    @Override
    public ReservationVO insertReservation(ReservationRequestDTO reservationRequestDTO) {

        ReservationVO reservationVO = new ReservationVO();
        reservationVO.setGuestNo(reservationRequestDTO.getGuestNo());
        reservationVO.setHostNo(reservationRequestDTO.getHostNo());
        reservationVO.setPlaceNo(reservationRequestDTO.getPlaceNo());
        reservationVO.setCheckinDate(reservationRequestDTO.getCheckinDate());
        reservationVO.setCheckoutDate(reservationRequestDTO.getCheckoutDate());
        reservationVO.setGuestCount(reservationRequestDTO.getGuestCount());
        reservationVO.setPeriod(reservationRequestDTO.getPeriod());
        reservationVO.setPrice(reservationRequestDTO.getTotalPrice());
        reservationVO.setStatusCode(0);
        reservationVO.setOrderId(reservationRequestDTO.getOrderId());

        reservationMapper.insertOne(reservationVO);

        return reservationMapper.findOneByOrderId(reservationRequestDTO.getOrderId());
    }

}
