package io.summer.popin.domain.search.controller;

import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search")
    public String searchList(@ModelAttribute SearchDTO searchDTO, Model model){
        log.info("SEARCH-TERM = {}", searchDTO);
        model.addAttribute("searchList",searchService.placesSearch(searchDTO));
        log.info(String.valueOf(searchService.placesSearch(searchDTO)));
        return "searchTest";
    }
}
