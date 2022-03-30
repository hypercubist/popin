package io.summer.popin.domain.member.dao;

import io.summer.popin.domain.member.dto.ProfileDTO;
import io.summer.popin.domain.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public ProfileDTO findByNo(Long no);
}
