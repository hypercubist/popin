package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dto.ProfileResponseDTO;

public interface MemberService {

    public ProfileResponseDTO profileFindByNo(Long MemberNo);

}
