package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dto.BookedDateResponseDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.review.dto.ReviewResponseDTO;

import java.util.List;


public interface PlaceService {

    PlaceDetailResponseDTO getPlaceDetail(int placeNo);

    List<String> getImageUrls(int placeNo);

    List<ReviewResponseDTO> getReviews(int placeNo);

    List<BookedDateResponseDTO> getBookedDates(int placeNo);
}
