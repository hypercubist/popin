package io.summer.popin.global.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UrlMapper {

    List<String> findListByPlaceNo(@Param("resourceKind") int resourceKind, @Param("placeNo") long placeNo);

    String findOneByPlaceNo(@Param("resourceKind") int resourceKind, @Param("placeNo") long placeNo);

    List<String> findListByReservationNo(@Param("resourceKind") int resourceKind, @Param("reservationNo") long reservationNo);

    String findOneByMemberNo(@Param("resourceKind") int resourceKind, @Param("memberNo") long memberNo);
}
