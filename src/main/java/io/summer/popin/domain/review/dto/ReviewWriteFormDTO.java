package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewWriteFormDTO {

    //review
    private Long placeNo;
    private Long guestNo;  //memberNo
    private Integer rating;
    private String content;
    private String reservationNo;

}
