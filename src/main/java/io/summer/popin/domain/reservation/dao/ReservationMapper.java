package io.summer.popin.domain.reservation.dao;

import io.summer.popin.domain.place.dto.BookedDateResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {

    List<BookedDateResponseDTO> findDateListByPlaceNo(int placeNo);


}
