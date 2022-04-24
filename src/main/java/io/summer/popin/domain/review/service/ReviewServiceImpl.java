package io.summer.popin.domain.review.service;

import io.summer.popin.domain.review.dao.ReviewMapper;
import io.summer.popin.domain.review.dto.MyReviewDTO;
import io.summer.popin.domain.review.dto.ReviewWriteFormDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    @Override
    public ReviewWriteFormDTO getReviewsForm(Long memberNo) {

        return reviewMapper.getReviewFormDataByMemberNo(memberNo);

    }

    @Override
    public MyReviewDTO getReviews(Long memberNo) {

        return reviewMapper.getReviewsByMemberNo(memberNo);

    }
}
