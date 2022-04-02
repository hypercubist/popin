package io.summer.popin.domain.place.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookedDateResponseDTO {
    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;
}
