package io.summer.popin.domain.place.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TempSearchRequestDTO {
    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;
}
