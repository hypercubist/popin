package io.summer.popin.domain.message.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MessageRequestDTO{

    private Integer no;

    private Integer senderNo;
    private Integer receiverNo;

    private String content;
    private LocalDate sendDate;
    private LocalDate receiveDate;

}
