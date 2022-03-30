package io.summer.popin.domain.member.controller;

import io.summer.popin.domain.member.dto.ProfileDTO;
import io.summer.popin.domain.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

//        @GetMapping("/login")
//        public void login() {
//
//
////            return "";
//        }

        @GetMapping("/members/{memberNo}")
        public String getProfile(@PathVariable("memberNo") Long memberNo, Model model) {

            ProfileDTO profile = memberServiceImpl.profileFindByNo(memberNo);
            model.addAttribute("profile", profile);
            return "profile";
        }

//        @GetMapping("/members/edit-photo/{memberNo}")
//        public String edit_profile_photo(@PathVariable("memberNo") Long memberNo) {
//
//
//
//        }



}
