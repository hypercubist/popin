package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;

import java.util.List;


public interface PlaceService {

    public PlaceDetailResponseDTO getPlaceDetail(int placeNo);

    public List<String> getImageUrls(int placeNo);
}
