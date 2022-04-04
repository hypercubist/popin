package io.summer.popin.domain.search.service;

import io.summer.popin.domain.search.dao.SearchMapper;
import io.summer.popin.domain.search.dto.SearchRequestDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{

    private final SearchMapper searchMapper;

    @Override
    public List<SearchResponseDTO> placesSearch(SearchRequestDTO dto) {
        String[] location = dto.getLocation().split(" ");
        dto.setRegion1depth(location[location.length-2]);
        dto.setRegion2depth(location[location.length-1]);

        return searchMapper.placesSearch(dto);
    }
}
