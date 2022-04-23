package io.summer.popin.domain.reservation.service;

import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.model.ResourceKind;
import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.ReservationRequestDTO;
import io.summer.popin.domain.reservation.dao.ReservationMapper;
import io.summer.popin.domain.reservation.dto.ReservationForHostInfoDTO;
import io.summer.popin.domain.reservation.dto.ReservationResponseDTO;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;
    private final UrlMapper urlMapper;

    @Override
    public ReservationResponseDTO getReservationDetail(Long reservationNo) {
        return reservationMapper.findOneByNo(reservationNo);
    }

    @Override
    public ReservationVO insertReservation(ReservationRequestDTO reservationRequestDTO) {

        ReservationVO reservationVO = new ReservationVO();
        reservationVO.setGuestNo(reservationRequestDTO.getGuestNo());
        reservationVO.setPlaceNo(reservationRequestDTO.getPlaceNo());
        reservationVO.setCheckinDate(reservationRequestDTO.getPickedCheckinDate());
        reservationVO.setCheckoutDate(reservationRequestDTO.getPickedCheckoutDate());
        reservationVO.setGuestCount(reservationRequestDTO.getGuestCount());
        reservationVO.setPeriod(reservationRequestDTO.getPeriod());
        reservationVO.setPrice(reservationRequestDTO.getTotalPrice());
        reservationVO.setStatusCode(0);
        reservationVO.setOrderId(reservationRequestDTO.getOrderId());

        reservationMapper.insertOne(reservationVO);

        return reservationMapper.findOneByOrderId(reservationRequestDTO.getOrderId());
    }

    @Override
    public List<String> getThumbnailUrl(Long reservationNo) {
        return urlMapper.findThumbnailUrlByReservationNo(ResourceKind.PLACE_THUMBNAIL.ordinal(), reservationNo);
    }

    @Override
    public List<String> getImageUrls(Long reservationNo) {
        return urlMapper.findUrlByReservationNo(ResourceKind.PLACE.ordinal(),reservationNo);
    }

    @Override
    public List<ReservationResponseDTO> getReservationsForGuest(SessionUserDTO loginMember) {

        return reservationMapper.findListByGuestNo(ResourceKind.PLACE_THUMBNAIL.ordinal(), loginMember.getNo());
    }

    @Override
    public ReservationForHostInfoDTO getReservationsForHost(SessionUserDTO loginMember) {

        return reservationMapper.getCountByHostNo(loginMember.getNo());

    }

    @Override
    public String getProfileImageUrl(Long reservationNo) {

        List<String> urls = urlMapper.findProfileUrlByReservationNo(ResourceKind.PROFILE.ordinal(), reservationNo);
        return urls.get(0);
    }

}
