package io.summer.popin.global.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    public String getTime();
    public String getHouseKind();
}
