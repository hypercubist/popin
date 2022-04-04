package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dao.MemberMapper;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public ProfileResponseDTO profileFindByNo(Long memberNo) {

        ProfileResponseDTO profile = memberMapper.profileFindByNo(memberNo);

        return profile;
    }



}
