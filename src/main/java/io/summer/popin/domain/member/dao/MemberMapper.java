package io.summer.popin.domain.member.dao;

import io.summer.popin.domain.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public MemberVO findByNo(Long MemberNo);
}
