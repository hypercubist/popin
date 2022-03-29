package io.summer.popin.domain.place.dto;

import lombok.Setter;

@Setter
public class PlacesResponseDTO {

    private String placeName;
    private String location;
    private String placeKind;
    private Double rating;
    private Integer reviewCount;
    private String thumbnailUrl;
    private Integer price;
    private Integer totalPrice;

}
