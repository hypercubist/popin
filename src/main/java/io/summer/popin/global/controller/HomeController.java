package io.summer.popin.global.controller;


import io.summer.popin.domain.search.dto.SearchRequestDTO;
import io.summer.popin.domain.search.dto.SearchResponseDTO;
import io.summer.popin.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "home";
    }

}