package io.summer.popin.domain.place.dao;


import io.summer.popin.domain.hosting.dto.ReservationCountResponseDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PlaceMapper {

    ReservationCountResponseDTO getCountByNo(long memberNo);

    PlaceDetailResponseDTO findOneByNo(long placeNo);

    ArrayList<String> findKindMap();


}
