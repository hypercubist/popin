package io.summer.popin.domain.place.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class ReservatedDateDTO {
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
}
