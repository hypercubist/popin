package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dto.ManagementMemberResponseDTO;
import io.summer.popin.domain.management.dto.MemberCountDTO;
import io.summer.popin.global.vo.Criteria;

import java.util.List;

public interface MemberManagementService {

    MemberCountDTO getMemberCount();
    Integer getSearchMemberCount(Criteria cri);
    List<String> getMemberClassList();
    List<ManagementMemberResponseDTO> getMemberList(Criteria cri);
}
