package io.summer.popin.domain.search.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchRequestDTO {

//    private AddressDTO addressDTO;

    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String location;

    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer maxGuest;

}
