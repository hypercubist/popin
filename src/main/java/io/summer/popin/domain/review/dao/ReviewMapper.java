package io.summer.popin.domain.review.dao;

import io.summer.popin.domain.review.dto.MyReviewDTO;
import io.summer.popin.domain.review.dto.ReviewWriteFormDTO;
import lombok.Data;

@Data
public interface ReviewMapper {

    ReviewWriteFormDTO getReviewFormDataByMemberNo(Long memberNo);

    MyReviewDTO getReviewsByMemberNo(Long memberNo);
}
