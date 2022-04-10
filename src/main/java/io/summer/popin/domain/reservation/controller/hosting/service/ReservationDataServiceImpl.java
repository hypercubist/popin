package io.summer.popin.domain.reservation.controller.hosting.service;

import io.summer.popin.domain.reservation.controller.hosting.dto.ReservationCountResponseDTO;
import io.summer.popin.domain.place.dao.PlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationDataServiceImpl implements ReservationDataService {

    private PlaceMapper placeMapper;


    @Override
    public ReservationCountResponseDTO getReservationCount(Long memberNo) {

        ReservationCountResponseDTO reservationCountResponse = placeMapper.getCountByNo(memberNo);

        return reservationCountResponse;
    }
}
