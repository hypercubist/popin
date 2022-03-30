package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dto.ProfileDTO;
import io.summer.popin.domain.member.vo.MemberVO;

import java.lang.reflect.Member;

public interface MemberService {

    public ProfileDTO profileFindByNo(Long MemberNo);

}
