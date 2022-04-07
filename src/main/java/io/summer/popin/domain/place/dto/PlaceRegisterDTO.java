package io.summer.popin.domain.place.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlaceRegisterDTO {

    private String placeName;
    private Integer hostNo;
    private Integer placeKindCode; //code or name?
    private String description;
    private Integer priceHigh;
    private Integer checkinTimeStart;
    private Integer checkinTimeEnd;
    private Integer checkoutTimeStart;
    private Integer checkoutTimeEnd;
    private String addressName;
    private Double coordX;
    private Double coordY;
    private String region1Depth;
    private String region2Depth;
    private String region3Depth;
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
}
