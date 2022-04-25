package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class MyReviewDTO {

    //url
    private String hostProfileUrl;

    //place
    private String region1depth;
    private String region2depth;

    //reservation
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    //review
    private String content;

}
