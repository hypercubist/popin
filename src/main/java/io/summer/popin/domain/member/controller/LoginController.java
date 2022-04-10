package io.summer.popin.domain.member.controller;


import io.summer.popin.domain.member.service.CustomOAuth2MemberserviceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final CustomOAuth2MemberserviceImpl customOAuth2MemberserviceImpl;

    @GetMapping("/oauth2/authorization/kakao")
    public String kakaoLogin(OAuth2UserRequest memberRequest, HttpSession session) {

        customOAuth2MemberserviceImpl.loadUser(memberRequest);

        return "redirect:/";
    }

}
