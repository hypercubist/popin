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
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageApiController {

    private final MessageService messageService;

    //메세지 상세정보
    @GetMapping("/detail")
    public List<MessageResponseDTO> messageDetailHandle(@ModelAttribute MessageRequestDTO dto){
        return messageService.messageDetail(dto);
    }

    //메세지 보낼시
    @PostMapping
    public ResponseEntity sendMessage(@ModelAttribute MessageRequestDTO dto) {
        return messageService.sendMessage(dto) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
