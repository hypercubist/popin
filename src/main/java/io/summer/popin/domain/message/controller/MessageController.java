package io.summer.popin.domain.message.controller;


import io.summer.popin.domain.message.dto.MessageSendDTO;
import io.summer.popin.domain.message.service.MessageService;
import io.summer.popin.domain.message.vo.MessageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/message/{senderNo}")
    public List<MessageVO> showAllMessage(@PathVariable Integer senderNo){
        return messageService.myMessageList(senderNo);
    }


    @PostMapping("/message")
    public ResponseEntity sendMessage(@ModelAttribute MessageSendDTO dto){
        return messageService.sendMessage(dto) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
