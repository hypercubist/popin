package io.summer.popin.domain.place.dao;

import io.summer.popin.domain.place.dto.PlaceListContentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PlaceMapper {

    public ArrayList<PlaceListContentDTO> getPlaceList();
}
