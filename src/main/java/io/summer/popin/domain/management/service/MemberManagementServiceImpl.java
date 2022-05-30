package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dao.ManagementMapper;
import io.summer.popin.domain.management.dto.ManagementMemberResponseDTO;
import io.summer.popin.domain.management.dto.MemberCountDTO;
import io.summer.popin.global.vo.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberManagementServiceImpl implements MemberManagementService{

    private final ManagementMapper managementMapper;

    @Override
    public MemberCountDTO getMemberCount() {
        MemberCountDTO countDTO = new MemberCountDTO();
        countDTO.setMemberTotalCount(managementMapper.getMemberTotalCount());
        countDTO.setTodayJoinCount(managementMapper.getTodayJoinCount());
        return countDTO;
    }

    @Override
    public Integer getSearchMemberCount(Criteria cri) {

        return managementMapper.getSearchMemberCount(cri);
    }

    @Override
    public List<String> getMemberClassList() {
        return managementMapper.getMemberClassList();
    }

    @Override
    public List<ManagementMemberResponseDTO> getMemberList(Criteria cri) {
        log.info("MEMBER SEARCH CRITERIA: {}", cri);
        return managementMapper.getMemberList(cri);
    }
}
