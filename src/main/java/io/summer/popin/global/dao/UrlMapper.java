package io.summer.popin.global.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UrlMapper {

    List<String> findListListByPlaceNo(int placeNo);

    List<String> findListByReservationNo(int reservationNo);

}
