package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ReviewReservationDTO {

    //reservation
    private Long reservationNo;
    private Long placeNo;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    //place
    private String placeName;
    private String region1depth;
    private String region2depth;

    //url
    private String placeThumbnail;
}
