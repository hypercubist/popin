package io.summer.popin.domain.message.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MessageResponseDTO {
    private Integer no;

    private Integer senderNo;
    private Integer receiverNo;

    private String content;
    private LocalDate sendDate;
    private LocalDate receiveDate;

    private LocalDate latestDate;
    private String name;
}

