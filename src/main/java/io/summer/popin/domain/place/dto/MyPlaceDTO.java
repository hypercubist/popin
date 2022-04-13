package io.summer.popin.domain.place.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyPlaceDTO {

    private Long placeNo;
    private String placeName;
    private String placeStatus;
    private String region1depth;
    private String region2depth;
    private String thumbnailUrl;
}
