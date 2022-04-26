package io.summer.popin.domain.review.controller;

import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.member.service.MemberService;
import io.summer.popin.domain.review.dto.ReviewWriteFormDTO;
import io.summer.popin.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public String reviewForm(@SessionAttribute("loginMember") SessionUserDTO loginMember, Model model, @ModelAttribute("reviewWriteForm") ReviewWriteFormDTO reviewWriteFormDTO) {
        Long memberNo = loginMember.getNo();

        if (reviewService.getReviewsForm(memberNo) != null) {
            model.addAttribute("reviewForms", reviewService.getReviewsForm(memberNo));
        }
        if (reviewService.getReviews(memberNo) != null) {
            model.addAttribute("myReviews", reviewService.getReviews(memberNo));
        }

        return "html/reviews";
    }

    @PostMapping
    public String addReview(@SessionAttribute("loginMember") SessionUserDTO loginMember, @ModelAttribute("reviewWriteForm") ReviewWriteFormDTO reviewWriteForm) {

        reviewWriteForm.setGuestNo(loginMember.getNo());
        log.info("reviewWriteForm = {}", reviewWriteForm);
        reviewService.saveReview(reviewWriteForm);

        return "redirect:/reviews";
    }

}
