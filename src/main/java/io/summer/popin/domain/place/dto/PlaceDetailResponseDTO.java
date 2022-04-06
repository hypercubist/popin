package io.summer.popin.domain.place.dto;

import io.summer.popin.domain.review.dto.ReviewResponseDTO;
import lombok.Data;

@Data
public class PlaceDetailResponseDTO {

    //place
    private String name;
    private Long hostNo;
    private String hostName;
    private String placeKind;
    private String description;
    private Integer priceHigh;
    private Integer checkinTimeStart;
    private Integer checkinTimeEnd;
    private Integer checkoutTimeStart;
    private Integer checkoutTimeEnd;
    private String addressName;
    private Integer coordX;
    private Integer coordY;
    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String roadName;
    private Integer mainBuildingNo;
    private Integer subBuildingNo;
    private String buildingName;
    private Integer roomCount;
    private Integer bathroomCount;
    private Integer bedSingle;
    private Integer bedDouble;
    private Integer bedQueen;
    private Integer bedKing;
    private Integer kitchen;
    private Integer parking;
    private Integer wifi;
    private Integer balcony;
    private Integer pool;
    private Integer airConditioner;
    private Integer bathtub;
    private Integer crib;
    private Integer tv;
    private Integer coffeeMachine;
    private Integer pc;
    private Integer blackBoard;
    private Integer beamProject;
    private Integer balloon;
    private Integer diningTable;
    private Integer lamp;
    private Integer kitchenTools;
    private Integer maxGuest;
    private Double rating;
    private Integer reviewCount;

}
