package io.summer.popin.domain.search.service;

import io.summer.popin.domain.search.dao.SearchMapper;
import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{

    private final SearchMapper searchMapper;

    @Override
    public List<SearchResponseDTO> placesSearch(SearchDTO searchDTO) {
        return searchMapper.placesSearch(searchDTO);
    }
}
