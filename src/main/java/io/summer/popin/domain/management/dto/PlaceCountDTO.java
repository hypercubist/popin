package io.summer.popin.domain.management.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlaceCountDTO {

    private Integer placeTotalCount;
    private Integer placePendingCount;
    private Integer placeActivatedCount;
    private Integer placeDeactivatedCount;
}
