package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.*;
import io.summer.popin.domain.review.dto.MyReviewDTO;
import io.summer.popin.domain.review.dto.ReviewDTO;

import java.util.List;

public interface PlaceService {

    PlaceDetailResponseDTO getPlaceDetail(Long placeNo);

    List<String> getImageUrls(Long placeNo);

    String getThumbnailUrl(Long placeNo);

    List<PlaceKindDTO> getPlaceKinds();

    KakaoLocalRoadAddressDTO getRoadAddress(Double coordX, Double coordY);

    Long registerPlace(PlaceRegisterDTO registerDTO);

    List<MyPlaceDTO> getPlaces(Long hostNo);

    Integer getMyPlacesCount(Long hostNo);

    List<ReservatedDateDTO> getReservatedDates(Long placeNo);

    List<ReviewDTO> getReviews(Long placeNo);
}