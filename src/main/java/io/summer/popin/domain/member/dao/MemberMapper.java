package io.summer.popin.domain.member.dao;

import io.summer.popin.domain.member.dto.KakaoGetUserInfoJsonResponseDTO;
import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {

    ProfileResponseDTO findProfileByMemberNo(Long no);

    ProfileUpdateDTO findEditProfileFormDataByMemberNo(Long memberNo);

    int updateProfileByMemberNo(MemberVO memberVO);

    int checkMember(Long id);

    int saveMember(Long id, String nickname, String email);
}
