package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dto.ReservationForHostInfoDTO;
import io.summer.popin.domain.reservation.dto.ReservationResponseDTO;
import io.summer.popin.domain.reservation.vo.ReservationVO;

import java.util.List;

public interface ReservationService {

    ReservationResponseDTO getReservationDetail(Long reservationNo);

    ReservationVO insertReservation(ReservationRequestDTO reservationRequestDTO);

    List<String> getImageUrls(Long reservationNo);

    List<ReservationResponseDTO> getReservationsForGuest(SessionUserDTO loginMember);

    ReservationForHostInfoDTO getReservationsForHost(SessionUserDTO loginMember);
}
