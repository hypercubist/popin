package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ReviewResponseDTO {

    private String guest;
    private Integer rating;
    private String content;
    private Date writingDate;
}
