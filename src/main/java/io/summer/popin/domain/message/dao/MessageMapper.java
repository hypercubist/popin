package io.summer.popin.domain.message.dao;

import io.summer.popin.domain.message.dto.MessageSendDTO;
import io.summer.popin.domain.message.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    public List<MessageVO> allMessage(Integer senderNo);

    public boolean sendMessage(MessageSendDTO dto);

}
