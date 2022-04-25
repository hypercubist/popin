package io.summer.popin.domain.review.service;

import io.summer.popin.domain.review.dao.ReviewMapper;
import io.summer.popin.domain.review.dto.MyReviewDTO;
import io.summer.popin.domain.review.dto.ReviewReservationDTO;
import io.summer.popin.domain.review.dto.ReviewWriteFormDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    @Override
    public List<ReviewReservationDTO> getReviewsForm(Long memberNo) {

        return reviewMapper.getReviewFormDataByMemberNo(memberNo);

    }

    @Override
    public List<MyReviewDTO> getReviews(Long memberNo) {
        List<MyReviewDTO> reviews =  reviewMapper.getReviewsByMemberNo(memberNo);
        for (MyReviewDTO review : reviews) {
            if (review.getHostProfileUrl() == null) {
                review.setHostProfileUrl("/img/profile_default.png");
            }
        }
        return reviews;
    }

    @Override
    public int saveReview(ReviewWriteFormDTO reviewWriteForm) {

        return reviewMapper.insertOne(reviewWriteForm);
    }
}
