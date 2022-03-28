package io.summer.popin.domain.reservation.vo;

import lombok.Data;

import java.sql.Date;


@Data
public class ReservationVO {
    private Long no;
    private Long placeNo;
    private Long hostNo;
    private Long guestNo;
    private Integer guestCount;
    private Date checkinDate;
    private Date checkoutDate;
    private Integer period;
    private Integer price;
    private Integer statusCode;
}
