package io.summer.popin.domain.search.dao;

import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    public List<SearchResponseDTO> placesSearch(SearchDTO dto);

}
