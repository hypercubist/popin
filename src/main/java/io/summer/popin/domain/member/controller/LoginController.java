package io.summer.popin.domain.member.controller;

import io.summer.popin.domain.member.dto.KakaoGetUserInfoJsonResponseDTO;
import io.summer.popin.domain.member.dto.KakaoUserDTO;
import io.summer.popin.domain.member.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

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

    //    @ResponseBody
//    @SessionAttribute("userDTO")
    @GetMapping("/kakao/callback")
    public void kakaoCallbackandAccessToken(@RequestParam("code") String code, HttpSession session, Model model) {

        log.info("kakaoCallbackCode = {}", code);
        String access_Token = kakaoLoginService.getKakaoAccessToken(code, session);
        KakaoUserDTO userDTO = kakaoLoginService.getUserInfo(access_Token, session);
        userDTO = kakaoLoginService.kakaoLogin(userDTO);

        model.addAttribute("user", userDTO);

//        return "";
    }

}
