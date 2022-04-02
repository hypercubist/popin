package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.place.service.PlacesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/places")
public class PlaceController {

    private final PlacesService placesService;

    @GetMapping
    public String placeList(Model model){

        return "place-list";
    }


}
