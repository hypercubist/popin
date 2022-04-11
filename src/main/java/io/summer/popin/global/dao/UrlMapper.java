package io.summer.popin.global.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UrlMapper {

    List<String> findUrlByPlaceNo(@Param("resourceKind") int resourceKind, @Param("placeNo") long placeNo);

    List<String> findUrlByReservationNo(@Param("resourceKind") int resourceKind, @Param("reservationNo") long reservationNo);

    List<String> findUrlByMemberNo(@Param("resourceKind") int resourceKind, @Param("memberNo") long memberNo);
}
