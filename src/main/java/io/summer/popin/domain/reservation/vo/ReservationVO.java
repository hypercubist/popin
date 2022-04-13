package io.summer.popin.domain.reservation.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ReservationVO {
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
}
