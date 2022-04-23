package io.summer.popin.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationForHostInfoDTO {

    //reservation
    private Long hostNo;
    private Integer hostingNowCount;  //checkedIn
    private Integer willCheckIn;
    private Integer willCheckOut;
    private Integer cancelled;
}
