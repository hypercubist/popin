package io.summer.popin.domain.message.controller;


import io.summer.popin.domain.message.dto.MessageRequestDTO;
import io.summer.popin.domain.message.dto.MessageResponseDTO;
import io.summer.popin.domain.message.service.MessageService;
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

//    @GetMapping("/{senderNo}")
//    public List<MessageResponseDTO> showAllMessage(@PathVariable("senderNo") MessageRequestDTO senderNo) {
//        return messageService.myMessageList(senderNo);
//    }

    @GetMapping("/detail")
    public List<MessageResponseDTO> messageDetailHandle(@ModelAttribute MessageRequestDTO dto){
        return messageService.messageDetail(dto);
    }

    @PostMapping
    public ResponseEntity sendMessage(@ModelAttribute MessageRequestDTO dto) {
        return messageService.sendMessage(dto) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
