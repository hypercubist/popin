package io.summer.popin.domain.search.service;

import io.summer.popin.domain.search.dto.SearchResponseDTO;
import io.summer.popin.global.vo.Criteria;
import io.summer.popin.domain.search.dto.SearchDTO;

import java.util.List;

public interface SearchService {

    public List<SearchResponseDTO> placesSearch(SearchDTO searchDTO, Criteria criteria);

    public int placeCount(SearchDTO searchDTO);

    public List<String> placeUrl(List<Long> placeNoArr);

}
