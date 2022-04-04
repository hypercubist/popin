package io.summer.popin.domain.member.controller;

import io.summer.popin.domain.member.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequestMapping("/login")
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final KakaoLoginService kakaoLoginService;

    @GetMapping("/kakao")
    public String kakaoLoginConnect() {

        String kakaoAuthCodeRequestURL = kakaoLoginService.getKakaoAuthCodeRequestURL();
        log.info("kakaoAuthCodeRequestURL = {}", kakaoAuthCodeRequestURL);
        return "redirect:" + kakaoAuthCodeRequestURL;
    }

    @RequestMapping(value = "/callback", produces="application/json",method= {RequestMethod.GET, RequestMethod.POST})
    public void kakaoLogin(@RequestParam("code")String code, RedirectAttributes ra, HttpSession session, HttpServletResponse response, Model model) {

        kakaoLoginService.getKakaoAuthCode(code);
    }


}
