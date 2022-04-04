package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;

public interface MemberService {

    ProfileResponseDTO findProfileByMemberNo(Long MemberNo);

    ProfileUpdateDTO getEditProfileFormData(Long memberNo);

    int updateProfile(Long memberNo, ProfileUpdateDTO profileUpdateDTO);
}
