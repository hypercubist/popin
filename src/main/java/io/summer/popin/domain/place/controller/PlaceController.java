package io.summer.popin.domain.place.controller;

import io.summer.popin.domain.place.dto.BookedDateResponseDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.service.PlaceService;
import io.summer.popin.domain.place.service.PlacesServiceImpl;
import io.summer.popin.domain.review.dto.ReviewResponseDTO;
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

        return "place-list"; //검색도메인으로 옮겨야함
    }

    @GetMapping("/{placeNo}")
    public String placeDetail(@PathVariable Integer placeNo, Model model){

        model.addAttribute("place", placeService.getPlaceDetail(placeNo));
        model.addAttribute("imageUrls", placeService.getImageUrls(placeNo));
        model.addAttribute("reviews", placeService.getReviews(placeNo));
        model.addAttribute("bookedDates", placeService.getBookedDates(placeNo));
        //달력api에서 어떤 형태의 데이터를 필요로하는지 확인 후 반환 api컨트롤러로 위치 바꿔야할 수 있음.
        //즐겨찾기 했는지 여부 : 로그인되었는지 먼저 확인 후 찾기 -> 판단하여 비어있는 하트 또는 채워진 하트 표시
        //
        return "place-detail";
    }
}
