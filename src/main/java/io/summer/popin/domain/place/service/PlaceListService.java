package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.PlaceListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceListService {

    private final PlaceMapper placeMapper;


    public List<PlaceListDTO> getPlaceList(){
        return placeMapper.getPlaceList();
    }

}
