package io.summer.popin.global.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrlMapper {

    public List<String> findListByPlaceNo(int placeNo);
}
