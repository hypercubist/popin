package io.summer.popin.domain.management.dao;

import io.summer.popin.domain.model.PlaceStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagementMapper {
    int getMemberTotalCount();
    int getTodayJoinCount();

    int getPlaceCountByStatus();
    int getPlaceCountByStatus(PlaceStatus status);

    int getTodayReservedCount();
    int getBeforeCheckinCount();
    int getNowStayingCount();


}
