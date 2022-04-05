package io.summer.popin.domain.message.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MessageVO {
    private Integer no;
    private Integer senderNo;
    private Integer receiverNo;
    private String content;
    private LocalDate sendDate;
    private LocalDate receiveDate;

}
