package io.summer.popin.domain.member.controller;


import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.service.MemberService;
import io.summer.popin.domain.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

//        @GetMapping("/login")
//        public void login() {
//
//
////            return "";
//        }

        @GetMapping("/members/{memberNo}")
        public String getProfile(@PathVariable("memberNo") Long memberNo, Model model) {


            ProfileResponseDTO profile = memberService.profileFindByNo(memberNo);
            model.addAttribute("profile", profile);
            return "profile";
        }

        @GetMapping("/profile/edit/{memberNo}")
        public String editProfile(@PathVariable("memberNo") Long memberNo, Model model) {


            return "updateProfileForm";
        }


//        @GetMapping("/members/edit-photo/{memberNo}")









}
