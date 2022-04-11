package io.summer.popin.domain.reservation.dao;

import io.summer.popin.domain.reservation.dto.ReservationResponseDTO;
import io.summer.popin.domain.reservation.vo.ReservationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {

    int insertOne(ReservationVO reservationVO);

    ReservationVO findOneByOrderId(String orderId);

    ReservationResponseDTO findOneByNo(long no);

    List<ReservationResponseDTO> findListByGuestNo(@Param("resourceKind")int resourceKind, @Param("memberNo")long memberNo);

}
