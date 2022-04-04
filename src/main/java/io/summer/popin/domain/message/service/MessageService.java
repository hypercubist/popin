package io.summer.popin.domain.message.service;

import io.summer.popin.domain.message.dto.MessageSendDTO;
import io.summer.popin.domain.message.vo.MessageVO;

import java.util.List;

public interface MessageService {

    public List<MessageVO> myMessageList(Integer senderNo);

    public boolean sendMessage(MessageSendDTO dto);

}
