package io.summer.popin.domain.management.dao;

import io.summer.popin.domain.management.dto.ManagementMemberDTO;
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
    List<ManagementMemberDTO> getMemberList(Criteria cri);
    ManagementMemberDTO getMember(Long memberNo);

    int deleteMember(Long memberNo);
    int updateMember(ManagementMemberDTO managementMemberDTO);

}
