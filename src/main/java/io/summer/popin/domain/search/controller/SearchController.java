package io.summer.popin.domain.search.controller;

import io.summer.popin.domain.search.dto.SearchRequestDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import io.summer.popin.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search")
    public String searchList(@ModelAttribute SearchRequestDTO dto, Model model){
        List<SearchResponseDTO> list =searchService.placesSearch(dto);
        model.addAttribute("dto",list);
        return "searchTest";
    }


}
