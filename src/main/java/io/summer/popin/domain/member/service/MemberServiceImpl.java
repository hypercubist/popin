package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dao.MemberMapper;
import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

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
    public int deleteProfile(Long memberNo) {

        return memberMapper.deleteProfile(memberNo);
    }


}
