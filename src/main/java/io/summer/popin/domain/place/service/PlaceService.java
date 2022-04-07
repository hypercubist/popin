package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.PlaceKindDTO;

import java.util.List;
import java.util.Map;


public interface PlaceService {

    PlaceDetailResponseDTO getPlaceDetail(int placeNo);

    List<String> getImageUrls(int placeNo);

    List<PlaceKindDTO> getPlaceKinds();

    String getKakaoMapsSource();
}
