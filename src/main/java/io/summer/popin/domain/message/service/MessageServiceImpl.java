package io.summer.popin.domain.message.service;

import io.summer.popin.domain.message.dao.MessageMapper;
import io.summer.popin.domain.message.dto.MessageSendDTO;
import io.summer.popin.domain.message.vo.MessageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageMapper messageMapper;

    @Override
    public List<MessageVO> myMessageList(Integer senderNo) {
        return messageMapper.allMessage(senderNo);
    }

    @Override
    public boolean sendMessage(MessageSendDTO dto) {
        return messageMapper.sendMessage(dto);
    }
}
