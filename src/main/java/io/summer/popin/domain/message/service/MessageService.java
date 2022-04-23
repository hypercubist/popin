package io.summer.popin.domain.message.service;

import io.summer.popin.domain.message.dto.MessageRequestDTO;
import io.summer.popin.domain.message.dto.MessageResponseDTO;

import java.util.List;

public interface MessageService {

    public List<MessageResponseDTO> myMessageList(Long senderNo);

    public boolean sendMessage(MessageRequestDTO dto);

    public List<MessageResponseDTO> messageDetail(MessageRequestDTO dto);
}
