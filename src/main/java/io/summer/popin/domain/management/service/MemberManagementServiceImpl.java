package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dao.ManagementMapper;
import io.summer.popin.domain.management.dto.ManagementMemberDTO;
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
    public List<ManagementMemberDTO> getMemberList(Criteria cri) {
        log.info("MEMBER SEARCH CRITERIA: {}", cri);
        return managementMapper.getMemberList(cri);
    }

    @Override
    public Boolean deleteMember(Long memberNo) {
        int result = managementMapper.deleteMember(memberNo);
        if(result > 0) {
            log.info("MEMBER-NO: {} IS DELETED, DELELE COUNT: {}", memberNo, result);
            return true;
        }
        else {
            log.info("MEMBER-NO: {} IS NOT DELETED", memberNo);
            return false;
        }
    }

    @Override
    public ManagementMemberDTO getMember(Long memberNo) {

        ManagementMemberDTO member = managementMapper.getMember(memberNo);
        log.info("MANAGEMENT-MEMBER : {}", member);
        return member;
    }

    @Override
    public Boolean updateMember(ManagementMemberDTO managementMemberDTO) {
        int result = managementMapper.updateMember(managementMemberDTO);
        long memberNo = managementMemberDTO.getNo();
        if (result > 0) {
            log.info("MEMBER-NO: {} IS UPDATED, UPDATE COUNT: {}", memberNo, result);
            return true;
        }else {
            log.info("MEMBER-NO: {} IS NOT UPDATED", memberNo);
            return false;
        }
    }
}
