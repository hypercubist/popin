package io.summer.popin.domain.member.dao;

import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public ProfileResponseDTO profileFindByNo(Long no);



}
