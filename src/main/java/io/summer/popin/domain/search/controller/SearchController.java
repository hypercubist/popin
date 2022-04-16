package io.summer.popin.domain.search.controller;

import io.summer.popin.domain.search.dto.Criteria;
import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.service.SearchService;
import io.summer.popin.domain.search.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("searchDTO")
public class SearchController {

    private final SearchService searchService;

    @ModelAttribute("searchDTO")
    public SearchDTO test(){
        return new SearchDTO();
    }

    @PostMapping("/search")
    public String searchListPost(@ModelAttribute("searchDTO") SearchDTO searchDTO, Model model, @RequestParam(defaultValue = "1") int pageNum){
        Criteria criteria = new Criteria(pageNum, 10);
        model.addAttribute("placesList",searchService.placesSearch(searchDTO,criteria));
        model.addAttribute("pageMaker", new PageVO(criteria,searchService.placeCount(searchDTO)));
        return "html/search";
    }

    @GetMapping("/search")
    public String searchListGet(@SessionAttribute("searchDTO") SearchDTO searchDTO,Model model, @RequestParam(defaultValue = "1") int pageNum){
        Criteria criteria = new Criteria(pageNum,10);
        model.addAttribute("placesList",searchService.placesSearch(searchDTO,criteria));
        model.addAttribute("pageMaker", new PageVO(criteria,searchService.placeCount(searchDTO)));
        log.info("ENDPAGE = {}",new PageVO(criteria,searchService.placeCount(searchDTO)).getEndPage());
        return "html/search";
    }
}
