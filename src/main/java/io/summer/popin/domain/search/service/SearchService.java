package io.summer.popin.domain.search.service;

import io.summer.popin.domain.search.dto.SearchRequestDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;

import java.util.List;

public interface SearchService {

    public List<SearchResponseDTO> placesSearch(SearchRequestDTO dto);

}
