package io.summer.popin.domain.place.dao;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.PlaceSearchRequestDTO;
import io.summer.popin.domain.place.dto.PlacesResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMapper {

    public List<PlacesResponseDTO> placesSearch(PlaceSearchRequestDTO requestDTO); //검색 도메인으로 옮겨야함

    public PlaceDetailResponseDTO findOneByNo(int placeNo);


}
