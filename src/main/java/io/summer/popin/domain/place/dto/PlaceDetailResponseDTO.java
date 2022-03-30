package io.summer.popin.domain.place.dto;

import java.sql.Date;

public class PlaceDetailResponseDTO {

    //place
    private String name;
    private String hostName; //join
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
    private Integer singleBed;
    private Integer superSingleBed;
    private Integer doubleBed;
    private Integer queenBed;
    private Integer kingBed;
    private Integer largeKingBed;
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

    //url
    private String[] imageUrl;

    //review
    private Double ratingAverage;
    private Integer reviewCount; //join
    private ReviewResponseDTO[] reviewList;


}
