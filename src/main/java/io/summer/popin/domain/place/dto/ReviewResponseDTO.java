package io.summer.popin.domain.place.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class ReviewResponseDTO {

    private String guest;
    private Integer rating;
    private String content;
    private Date writingDate;
}
