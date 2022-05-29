package io.summer.popin.domain.search.controller;

import io.summer.popin.domain.model.ResourceKind;
import io.summer.popin.global.vo.Criteria;
import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import io.summer.popin.domain.search.service.SearchService;
import io.summer.popin.domain.search.vo.PageVO;
import io.summer.popin.global.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("searchDTO")
public class SearchController {

    private final SearchService searchService;
    private final UrlService urlService;

    @ModelAttribute("searchDTO")
    public SearchDTO test(){
        return new SearchDTO();
    }

    @GetMapping("/search")
    public String searchListGet(@SessionAttribute("searchDTO") SearchDTO searchDTO,Model model, @RequestParam(defaultValue = "1") int pageNum){
        Criteria criteria = new Criteria(pageNum,10);
        model.addAttribute("placesList",searchService.placesSearch(searchDTO,criteria));
        model.addAttribute("pageMaker", new PageVO(criteria,searchService.placeCount(searchDTO)));
        model.addAttribute("currentPageNum",pageNum);
        model.addAttribute("kakaoMapsSource", urlService.getKakaoMapsSource());
        return "html/search";
    }

    @PostMapping("/search")
    public String searchListPost(@ModelAttribute("searchDTO") SearchDTO searchDTO, Model model, @RequestParam(defaultValue = "1") int pageNum){
        Map<String,String> coord = new HashMap<String,String>();
        coord.put("coordX",searchDTO.getCoordX());
        coord.put("coordY",searchDTO.getCoordY());
        Criteria criteria = new Criteria(pageNum, 10);
        List<SearchResponseDTO> placeNoList = searchService.placesSearch(searchDTO,criteria);
        List<Long> placeNo= new ArrayList<>();
        for (SearchResponseDTO i: placeNoList) {
            placeNo.add(i.getPlaceNo());
        }
        SearchResponseDTO searchResponseDTO = new SearchResponseDTO();
        searchResponseDTO.setPlaceNoArr(placeNo);
        List<Long> placeNoArr =searchResponseDTO.getPlaceNoArr();
        ResourceKind.PLACE_THUMBNAIL.ordinal();
        model.addAttribute("imgUrl",searchService.placeUrl(placeNoArr));
        model.addAttribute("coord",coord);
        model.addAttribute("placesList",searchService.placesSearch(searchDTO,criteria));
        model.addAttribute("pageMaker", new PageVO(criteria,searchService.placeCount(searchDTO)));
        model.addAttribute("currentPageNum",pageNum);
        model.addAttribute("kakaoMapsSource", urlService.getKakaoMapsSource());

        return "html/search";
    }
}
