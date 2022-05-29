package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dao.ManagementMapper;
import io.summer.popin.domain.management.dto.ManagementMemberResponseDTO;
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
    public List<String> getMemberClassList() {
        return managementMapper.getMemberClassList();
    }

    @Override
    public List<ManagementMemberResponseDTO> getMemberList(Criteria cri) {
        log.info("MEMBER LIST PAGE: {}", cri.getPageNum());
        return managementMapper.getMemberList(cri);
    }
}
