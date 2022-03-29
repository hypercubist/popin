package io.summer.popin.domain.place.dto;

import lombok.Data;

@Data
public class PlaceListDTO {

    private String placeName;
    private String location;
    private String placeKind;
    private Double rating;
    private Integer reviewCount;
    private String thumbnailUrl;
    private Integer price;
    private Integer totalPrice;

}
