package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.hosting.dto.ReservationCountResponseDTO;
import io.summer.popin.domain.place.dto.PlaceSearchRequestDTO;
import io.summer.popin.domain.place.dto.PlacesResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlacesServiceImpl implements PlacesService{

    private final PlaceMapper placeMapper;


    public List<PlacesResponseDTO> getPlaceList(PlaceSearchRequestDTO requestDTO){
        return placeMapper.placesSearch(requestDTO);
    }


}
