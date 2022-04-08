package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.KakaoLocalRoadAddressDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.PlaceKindDTO;
import io.summer.popin.domain.place.dto.PlaceRegisterDTO;
import io.summer.popin.domain.place.vo.PlaceVO;

import java.util.List;

public interface PlaceService {

    PlaceDetailResponseDTO getPlaceDetail(int placeNo);

    List<String> getImageUrls(int placeNo);

    List<PlaceKindDTO> getPlaceKinds();

    String getKakaoMapsSource();

    KakaoLocalRoadAddressDTO getRoadAddress(Double coordX, Double coordY);

    PlaceVO registerPlace(PlaceRegisterDTO registerDTO);
}
