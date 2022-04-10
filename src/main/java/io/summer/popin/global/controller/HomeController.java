package io.summer.popin.global.controller;


import io.summer.popin.domain.member.dto.LoginMemberInfoDTO;
import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.search.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@ModelAttribute SearchDTO serachDTO, @SessionAttribute(name="loginMember", required = false) SessionUserDTO loginMember){

        log.info("LOGIN MEMBER = {}", loginMember);
        return "home";
    }

    @GetMapping("/layout")
    public String layoutHome(){
        return "html/sample";
    }

}