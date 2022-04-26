package io.summer.popin.domain.search.dao;

import io.summer.popin.domain.search.dto.Criteria;
import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {

    public List<SearchResponseDTO> placesSearch(@Param("searchDTO")SearchDTO searchDTO,@Param("criteria")Criteria criteria);

    public int placeCount(SearchDTO searchDTO);

    public List<String> findUrlByMemberNo(List<Long> placeNoArr);
}
