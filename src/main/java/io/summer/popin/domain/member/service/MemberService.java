package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dto.MemberProfileResponseDTO;
import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;

public interface MemberService {

    ProfileResponseDTO findProfileByMemberNo(Long MemberNo);

    MemberProfileResponseDTO findMemberProfile(Long memberNo);

    ProfileUpdateDTO getEditProfileFormData(Long memberNo);

    int updateProfile(Long memberNo, ProfileUpdateDTO profileUpdateDTO);

    String getProfileImageUrl(Long memberNo);
}
