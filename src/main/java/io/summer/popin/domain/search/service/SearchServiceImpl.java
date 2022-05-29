package io.summer.popin.domain.search.service;

import io.summer.popin.domain.search.dto.SearchResponseDTO;
import io.summer.popin.domain.search.dao.SearchMapper;
import io.summer.popin.global.vo.Criteria;
import io.summer.popin.domain.search.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService{

    private final SearchMapper searchMapper;

    @Override
    public List<SearchResponseDTO> placesSearch(SearchDTO searchDTO, Criteria criteria) {

        return searchMapper.placesSearch(searchDTO,criteria);
    }

    @Override
    public int placeCount(SearchDTO searchDTO) {
        log.info("COUNT={}",searchMapper.placeCount(searchDTO));
        return searchMapper.placeCount(searchDTO);
    }

    public List<String> placeUrl(List<Long> placeNoArr){
        if(placeNoArr.size()>0){
            return searchMapper.findUrlByMemberNo(placeNoArr);
        }else {
            return null;
        }

    }


}
