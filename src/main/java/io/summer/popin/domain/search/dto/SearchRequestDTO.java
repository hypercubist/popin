package io.summer.popin.domain.search.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class SearchRequestDTO {

    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String location;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkinDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;
    private Integer maxGuest;

}
