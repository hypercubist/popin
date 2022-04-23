package io.summer.popin.domain.message.controller;

import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    //메세지화면 view
    @GetMapping
    public String messageView(Model model, HttpSession session, @SessionAttribute("loginMember") SessionUserDTO loginMember){
        log.info("SESSION-DATA ={}",loginMember.getNo());
        model.addAttribute("messageDTO", messageService.myMessageList(loginMember.getNo()));
        return "html/message";
    }

}
