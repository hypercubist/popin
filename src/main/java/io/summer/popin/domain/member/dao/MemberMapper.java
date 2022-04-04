package io.summer.popin.domain.member.dao;

import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    ProfileResponseDTO findProfileByMemberNo(Long no);


    ProfileUpdateDTO findEditProfileFormDataByMemberNo(Long memberNo);

    int updateProfileByMemberNo(MemberVO memberVO);

    int deleteProfile(Long memberNo);
}
