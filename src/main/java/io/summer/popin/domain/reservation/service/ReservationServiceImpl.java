package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dao.ReservationMapper;
import io.summer.popin.domain.reservation.dto.ReservationResponseDTO;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;
    private final UrlMapper urlMapper;

    @Override
    public ReservationResponseDTO getReservationDetail(int reservationNo) {
        return reservationMapper.findOneByNo(reservationNo);
    }

    @Override
    public ReservationVO insertReservation(ReservationRequestDTO reservationRequestDTO) {

        ReservationVO reservationVO = new ReservationVO();
        reservationVO.setGuestNo(reservationRequestDTO.getGuestNo());
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

    @Override
    public List<String> getImageUrls(int reservationNo) {
        return urlMapper.findListByReservationNo(reservationNo);
    }

}
