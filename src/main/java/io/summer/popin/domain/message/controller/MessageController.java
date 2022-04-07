package io.summer.popin.domain.message.controller;

import io.summer.popin.domain.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

//    @GetMapping
//    public String messageView1(){
//        return "message";
//    }

    @GetMapping
    public String messageView(Model model, HttpSession session){
        session.setAttribute("senderNo",1);
        model.addAttribute("dto", messageService.myMessageList((Integer) session.getAttribute("senderNo")));
        return "message";
    }





}
