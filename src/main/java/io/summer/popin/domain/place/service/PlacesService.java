package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.PlaceSearchRequestDTO;
import io.summer.popin.domain.place.dto.PlacesResponseDTO;

import java.util.List;

public interface PlacesService {

    public List<PlacesResponseDTO> getPlaceList(PlaceSearchRequestDTO requestDTO);


}

