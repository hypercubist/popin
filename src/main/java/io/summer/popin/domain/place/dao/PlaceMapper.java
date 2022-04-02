package io.summer.popin.domain.place.dao;

import io.summer.popin.domain.hosting.dto.ReservationCountResponseDTO;
import io.summer.popin.domain.place.dto.PlaceSearchRequestDTO;
import io.summer.popin.domain.place.dto.PlacesResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PlaceMapper {

    public ArrayList<PlacesResponseDTO> placesSearch(PlaceSearchRequestDTO requestDTO);

    public ReservationCountResponseDTO getCountByNo(Long memberNo);
}
