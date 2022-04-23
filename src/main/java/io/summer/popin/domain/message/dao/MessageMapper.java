package io.summer.popin.domain.message.dao;

import io.summer.popin.domain.message.dto.MessageRequestDTO;
import io.summer.popin.domain.message.dto.MessageResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    public List<MessageResponseDTO> allMessage(Long senderNo);

    public boolean sendMessage(MessageRequestDTO dto);

    public List<MessageResponseDTO> messageDetail(MessageRequestDTO dto);

}
