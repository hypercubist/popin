package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;

import java.util.List;
import java.util.Map;


public interface PlaceService {

    public PlaceDetailResponseDTO getPlaceDetail(int placeNo);

    public List<String> getImageUrls(int placeNo);

    public List<String> getPlaceKind();
}
