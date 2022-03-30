package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dao.MemberMapper;
import io.summer.popin.domain.member.dto.ProfileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public ProfileDTO profileFindByNo(Long memberNo) {

        ProfileDTO profile = memberMapper.findByNo(memberNo);

        return profile;
    }
}
