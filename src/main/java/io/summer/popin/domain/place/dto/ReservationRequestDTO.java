package io.summer.popin.domain.place.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ReservationRequestDTO {

    private Long placeNo;
    private Long GuestNo;
    private Integer guestCount;
    private String pickedDates;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickedCheckinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickedCheckoutDate;
    private Integer period;
    private Integer totalPrice;
    private Integer statusCode;
    private String orderId;
}
