package io.summer.popin.domain.review.dao;

import io.summer.popin.domain.review.dto.ReviewResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    public List<ReviewResponseDTO> findListByPlaceNo(int placeNo);
}
