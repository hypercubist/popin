package io.summer.popin.domain.management.dao;

import io.summer.popin.domain.management.dto.ManagementMemberResponseDTO;
import io.summer.popin.domain.model.PlaceStatus;
import io.summer.popin.global.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagementMapper {

    int getMemberTotalCount();
    int getTodayJoinCount();
    int getPlaceCountByStatus();
    int getPlaceCountByStatus(PlaceStatus status);
    int getTodayReservedCount();
    int getBeforeCheckinCount();
    int getNowStayingCount();
    int getSearchMemberCount(Criteria cri);

    List<String> getMemberClassList();
    List<String> getPlaceStatusList();
    List<String> getReservationStatusList();
    List<ManagementMemberResponseDTO> getMemberList(Criteria cri);


}
