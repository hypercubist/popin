package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.PlaceListContentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceListService {

    private final PlaceMapper placeMapper;

    public List<PlaceListContentDTO> search(){
        return placeMapper.getPlaceList();
    }

}
