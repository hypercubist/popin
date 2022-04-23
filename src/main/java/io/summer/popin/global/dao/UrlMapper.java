package io.summer.popin.global.dao;

import io.summer.popin.global.dto.UrlResourceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UrlMapper {

    List<String> findUrlByPlaceNo(@Param("resourceKind") int resourceKind, @Param("placeNo") long placeNo);

    List<String> findThumbnailUrlByReservationNo(@Param("resourceKind") int resourceKind,  @Param("reservationNo") long reservationNo);

    List<String> findUrlByReservationNo(@Param("resourceKind") int resourceKind, @Param("reservationNo") long reservationNo);

    List<String> findUrlByMemberNo(@Param("resourceKind") int resourceKind, @Param("memberNo") long memberNo);

    int insertUrl(UrlResourceDTO urlResourceDTO);

    int deleteUrl(UrlResourceDTO urlResourceDTO);

    List<String> findProfileUrlByReservationNo(@Param("resourceKind") int resourceKind, @Param("reservationNo") long reservationNo);
}
