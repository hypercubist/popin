package io.summer.popin.domain.place.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class PlaceRegisterDTO {

    @NotBlank
    private String placeName;
    private Integer hostNo;
    @NotNull
    private Integer placeKindCode; //code or name?
    @Length(min=100, max=2000)
    private String description;
    @NotNull
    private Integer priceHigh;
    @NotNull
    private Integer checkinTimeStart;
    @NotNull
    private Integer checkinTimeEnd;
    @NotNull
    private Integer checkoutTimeStart;
    @NotNull
    private Integer checkoutTimeEnd;
    @NotBlank
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
    @NotNull
    private Integer maxGuest;
}
