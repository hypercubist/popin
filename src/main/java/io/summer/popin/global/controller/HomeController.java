package io.summer.popin.global.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {

    private final PlacesService placesService;

    @GetMapping
    public String home(){

        return "home";
    }

    @PostMapping
    public String homeSearch(@ModelAttribute PlaceSearchRequestDTO requestDTO, Model model){


        model.addAttribute("places",placesService.getPlaceList(requestDTO));

        return "places";
    }
}