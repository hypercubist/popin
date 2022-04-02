package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public String placeList(Model model){

        return "place-list";
    }


    @GetMapping("/{placeNo}")
    public String placeDetail(@PathVariable Integer placeNo, Model model){

        PlaceDetailResponseDTO place = placeService.getPlaceDetail(placeNo);
        List<String> imageUrls = placeService.getImageUrls(placeNo);
        log.info("placeNo = {}", placeNo);
        log.info("PLACE = {}", place);
        model.addAttribute("place", place);
        model.addAttribute("imageUrls", imageUrls);

        return "place-detail";
    }

}
