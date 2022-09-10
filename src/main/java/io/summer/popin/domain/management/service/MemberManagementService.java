package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dto.ManagementMemberDTO;
import io.summer.popin.domain.management.dto.MemberCountDTO;
import io.summer.popin.global.vo.Criteria;

import java.util.List;

public interface MemberManagementService {

    MemberCountDTO getMemberCount();
    Integer getSearchMemberCount(Criteria cri);
    List<String> getMemberClassList();
    List<ManagementMemberDTO> getMemberList(Criteria cri);
    ManagementMemberDTO getMember(Long memberNo);
    Boolean deleteMember(Long memberNo);
    Boolean updateMember(ManagementMemberDTO managementMemberDTO);
}
