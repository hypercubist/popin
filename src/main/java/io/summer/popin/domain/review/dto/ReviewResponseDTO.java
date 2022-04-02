package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewResponseDTO {

    private String guest;
    private Integer rating;
    private String content;
    private LocalDateTime writingDate;
}
