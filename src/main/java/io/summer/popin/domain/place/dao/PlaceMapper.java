package io.summer.popin.domain.place.dao;


import io.summer.popin.domain.hosting.dto.ReservationCountResponseDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMapper {

    public ReservationCountResponseDTO getCountByNo(Long memberNo);

    public PlaceDetailResponseDTO findOneByNo(int placeNo);

}
