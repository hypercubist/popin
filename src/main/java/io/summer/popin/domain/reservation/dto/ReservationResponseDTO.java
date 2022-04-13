package io.summer.popin.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReservationResponseDTO {

    //reservation
    private Long no;
    private Long placeNo;
    private Long hostNo;
    private Long guestNo;
    private Integer guestCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;
    private Integer period;
    private Integer price;
    private Integer statusCode;
    private String orderId;

    //place
    private String placeName;
    private String description;
    private Integer checkinTimeStart;
    private Integer checkinTimeEnd;
    private Integer checkoutTimeStart;
    private Integer checkoutTimeEnd;
    private String addressName;
    private Integer coordX;
    private Integer coordY;
    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String roadName;
    private Integer mainBuildingNo;
    private Integer subBuildingNo;
    private String buildingName;

    //member
    private String hostName;
}
