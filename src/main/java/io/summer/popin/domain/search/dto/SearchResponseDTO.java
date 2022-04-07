package io.summer.popin.domain.search.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchResponseDTO {
//리스트 안에 정보
    private String placeName;
    private String location;
    private String placeKind;
    private Double rating;
    private Integer reviewCount;
    private String thumbnailUrl;
    private Integer price;
    private Integer totalPrice;

}
