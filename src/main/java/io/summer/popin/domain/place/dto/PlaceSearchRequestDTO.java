package io.summer.popin.domain.place.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PlaceSearchRequestDTO {

    private String location;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer guestCount;
}
