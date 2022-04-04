package io.summer.popin.domain.message.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageSendDTO{

    private Integer no;
    private Integer senderNo;
    private Integer receiverNo;
    private String content;
    private LocalDateTime sendDate;
    private LocalDateTime receiveDate;

}
