package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.place.service.PlaceListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/places")
public class PlaceController {

    private final PlaceListService placeListService;
    @GetMapping
    public String placeList(){

        log.info("PLACE LIST={}", placeListService.search());
        return "place-list";
    }
}
