package io.summer.popin.domain.place.dao;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.PlaceKindDTO;
import io.summer.popin.domain.place.dto.MyPlaceDTO;
import io.summer.popin.domain.place.dto.ReservatedDateDTO;
import io.summer.popin.domain.place.vo.PlaceVO;
import io.summer.popin.domain.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface PlaceMapper {

    PlaceDetailResponseDTO findOneByNo(long placeNo);

    ArrayList<PlaceKindDTO> findKindMap();

    int insertOne(PlaceVO placeVO);

    ArrayList<MyPlaceDTO> findPlaceListByHostNo(@Param("resourceKind") int resourceKind, @Param("hostNo") long hostNo);

    int getPlacesCountByHostNo(long hostNo);

    ArrayList<ReservatedDateDTO> findReservationByPlaceNo(long placeNo);

    ArrayList<ReviewDTO> findReviewByPlaceNo(long placeNo);
}
