package io.summer.popin.persistence;

import io.summer.popin.domain.search.dto.SearchRequestDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import io.summer.popin.domain.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class SearchTest {

    @Autowired
    public SearchService searchService;


    @Test
    public void searchTest(){
//        SearchRequestDTO dto = new SearchRequestDTO();
//        dto.setRegion1depth("metus");
//        dto.setRegion2depth("neque");
//        List<SearchResponseDTO> list  = searchService.placesSearch(dto);
//        for (SearchResponseDTO i : list){
//            log.info("가 1과 2에 들어가는 지역"+i.getPlaceName());
        }
    }


}
