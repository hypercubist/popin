package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewWriteFormDTO {

    //review
    private Long placeNo;
    private Long guestNo;  //memberNo
    private Integer rating;
    private String content;
    private String reservationNo;

}
