package io.summer.popin.domain.search.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class SearchDTO {

    private String addressName;
    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String coordX;
    private String coordY;

    private String dates;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkinDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;
    private Integer maxGuest;


}
