package io.summer.popin.domain.review.service;

import io.summer.popin.domain.review.dto.MyReviewDTO;
import io.summer.popin.domain.review.dto.ReviewReservationDTO;
import io.summer.popin.domain.review.dto.ReviewWriteFormDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

public interface ReviewService {

    List<ReviewReservationDTO> getReviewsForm(Long memberNo);

    List<MyReviewDTO> getReviews(Long memberNo);

    int saveReview(ReviewWriteFormDTO reviewWriteForm);
}
