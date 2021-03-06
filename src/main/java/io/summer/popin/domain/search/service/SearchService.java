package io.summer.popin.domain.search.service;

import io.summer.popin.domain.search.dto.Criteria;
import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;

import java.util.List;

public interface SearchService {

    public List<SearchResponseDTO> placesSearch(SearchDTO searchDTO, Criteria criteria);

    public int placeCount(SearchDTO searchDTO);

}
