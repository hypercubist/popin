package io.summer.popin.domain.search.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class SearchResponseDTO {

    private String placeName;
    private List<Long> placeNoArr;
    private Long placeNo; //장소 번호
    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String location;
    private String coordX;
    private String coordY;

    private String placeKind;
    private Double rating;
    private Integer reviewCount;
    private Integer price;
    private Integer totalPrice;
    private String maxGuest;

    private String thumbnailUrl;

}
