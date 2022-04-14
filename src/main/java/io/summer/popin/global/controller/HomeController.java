package io.summer.popin.global.controller;


import io.summer.popin.domain.search.dto.SearchDTO;
import io.summer.popin.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final SearchService searchService;

    @GetMapping("/")

    public String home(@ModelAttribute SearchDTO searchDTO){
        return "home";
    }

}