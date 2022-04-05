package io.summer.popin.domain.message.controller;


import io.summer.popin.domain.message.dto.MessageSendDTO;
import io.summer.popin.domain.message.service.MessageService;
import io.summer.popin.domain.message.vo.MessageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/message")
public class MessageApiController {

    private final MessageService messageService;

    @GetMapping("/{senderNo}")
    public ResponseEntity<List<MessageVO>> showAllMessage(@PathVariable("senderNo") Integer senderNo) {
        return new ResponseEntity<List<MessageVO>>(messageService.myMessageList(senderNo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity sendMessage(@ModelAttribute MessageSendDTO dto) {
        return messageService.sendMessage(dto) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
