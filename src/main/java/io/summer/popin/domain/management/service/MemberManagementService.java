package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dto.ManagementMemberResponseDTO;
import io.summer.popin.global.vo.Criteria;

import java.util.List;

public interface MemberManagementService {

    List<String> getMemberClassList();
    List<ManagementMemberResponseDTO> getMemberList(Criteria cri);
}
