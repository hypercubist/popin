package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dao.MemberMapper;
import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.vo.MemberVO;
import io.summer.popin.domain.model.ResourceKind;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;
    private final UrlMapper urlMapper;

    @Override
    public ProfileResponseDTO findProfileByMemberNo(Long memberNo) {

        ProfileResponseDTO profile = memberMapper.findProfileByMemberNo(memberNo);

        return profile;
    }

    @Override
    public ProfileUpdateDTO getEditProfileFormData(Long memberNo) {

        return memberMapper.findEditProfileFormDataByMemberNo(memberNo);
    }

    @Override
    public int updateProfile(Long memberNo, ProfileUpdateDTO profileUpdateDTO) {

        MemberVO memberVO = new MemberVO();

        memberVO.setNo(memberNo);
        memberVO.setName(profileUpdateDTO.getName());
        memberVO.setPhoneNumber(profileUpdateDTO.getPhoneNumber());

        return memberMapper.updateProfileByMemberNo(memberVO);
    }

    @Override
    public String getProfileImageUrl(Long memberNo) {
        return urlMapper.findUrlByMemberNo(ResourceKind.PROFILE.ordinal(), memberNo).get(0);
    }


}
