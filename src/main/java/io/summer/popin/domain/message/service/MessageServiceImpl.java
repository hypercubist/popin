package io.summer.popin.domain.message.service;

import io.summer.popin.domain.message.dao.MessageMapper;
import io.summer.popin.domain.message.dto.MessageRequestDTO;
import io.summer.popin.domain.message.dto.MessageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageMapper messageMapper;

    @Override
    public List<MessageResponseDTO> myMessageList(Long senderNo) {
        return messageMapper.allMessage(senderNo);
    }

    @Override
    public boolean sendMessage(MessageRequestDTO dto) {
        return messageMapper.sendMessage(dto);
    }

    @Override
    public List<MessageResponseDTO> messageDetail(@ModelAttribute MessageRequestDTO dto) {
        return messageMapper.messageDetail(dto);
    }
}
