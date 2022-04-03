package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.BookedDateResponseDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.reservation.dao.ReservationMapper;
import io.summer.popin.domain.review.dao.ReviewMapper;
import io.summer.popin.domain.review.dto.ReviewResponseDTO;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService{

    private final PlaceMapper placeMapper;
    private final UrlMapper urlMapper;
    private final ReviewMapper reviewMapper;
    private final ReservationMapper reservationMapper;

    @Override
    public PlaceDetailResponseDTO getPlaceDetail(int placeNo) {
        return placeMapper.findOneByNo(placeNo);
    }

    @Override
    public List<String> getImageUrls(int placeNo) {
        return urlMapper.findListByPlaceNo(placeNo);
    }

    @Override
    public List<ReviewResponseDTO> getReviews(int placeNo) {
        return reviewMapper.findListByPlaceNo(placeNo);
    }

    @Override
    public List<BookedDateResponseDTO> getBookedDates(int placeNo) {
        return reservationMapper.findDateListByPlaceNo(placeNo);
    }
}
