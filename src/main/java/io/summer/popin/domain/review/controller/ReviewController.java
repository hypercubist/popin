package io.summer.popin.domain.review.controller;

import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.member.service.MemberService;
import io.summer.popin.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/reviews")
@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final MemberService memberService;

    @GetMapping
    public String reviewForm(@SessionAttribute("loginMember") SessionUserDTO loginMember, Model model) {
        Long memberNo = loginMember.getNo();

        if (reviewService.getReviewsForm(memberNo) != null) {
            model.addAttribute(reviewService.getReviewsForm(memberNo));
        }
        if (reviewService.getReviews(memberNo) != null) {
            model.addAttribute("myReviews", reviewService.getReviews(memberNo));
        }
        return "html/reviews";
    }
}
