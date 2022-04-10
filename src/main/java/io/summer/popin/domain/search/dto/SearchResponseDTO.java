package io.summer.popin.domain.search.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchResponseDTO {

    private String placeName;
    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String location;
    private String placeKind;
    private Double rating;
    private Integer reviewCount;
    private Integer price;
    private Integer totalPrice;

    private String thumbnailUrl;

}
