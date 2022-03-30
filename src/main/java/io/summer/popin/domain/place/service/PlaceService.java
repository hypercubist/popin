package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;


public interface PlaceService {

    public PlaceDetailResponseDTO getPlaceDetail(int placeNo);
}
