package io.summer.popin.domain.reservation.dao;

import io.summer.popin.domain.reservation.vo.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    int insertOne(ReservationVO reservationVO);

    ReservationVO findOneByOrderId(String orderId);

    ReservationVO findOneByNo(long no);
}
