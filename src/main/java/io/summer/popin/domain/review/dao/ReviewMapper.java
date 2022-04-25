package io.summer.popin.domain.review.dao;

import io.summer.popin.domain.review.dto.MyReviewDTO;
import io.summer.popin.domain.review.dto.ReviewReservationDTO;
import io.summer.popin.domain.review.dto.ReviewWriteFormDTO;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    List<ReviewReservationDTO> getReviewFormDataByMemberNo(Long memberNo);

    List<MyReviewDTO> getReviewsByMemberNo(Long memberNo);

    int insertOne(ReviewWriteFormDTO reviewWriteForm);
}
