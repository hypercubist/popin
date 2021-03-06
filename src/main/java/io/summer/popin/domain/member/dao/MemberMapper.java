package io.summer.popin.domain.member.dao;

import io.summer.popin.domain.member.dto.LoginMemberInfoDTO;
import io.summer.popin.domain.member.dto.MemberProfileResponseDTO;
import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    ProfileResponseDTO findProfileByMemberNo(Long memberNo);

    MemberProfileResponseDTO findMemberProfileByMemberNo(Long memberNo);

    ProfileUpdateDTO findEditProfileFormDataByMemberNo(Long memberNo);

    int updateProfileByMemberNo(MemberVO memberVO);

    //기존 회원 체크
    LoginMemberInfoDTO findMemberById(Long id);

    int saveMember(LoginMemberInfoDTO loginMemberInfoDTO);


    int updateMember(LoginMemberInfoDTO infoDTO);
}
