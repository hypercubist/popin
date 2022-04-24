package io.summer.popin.domain.review.service;

import io.summer.popin.domain.review.dto.MyReviewDTO;
import io.summer.popin.domain.review.dto.ReviewWriteFormDTO;

public interface ReviewService {

    ReviewWriteFormDTO getReviewsForm(Long memberNo);

    MyReviewDTO getReviews(Long memberNo);
}
