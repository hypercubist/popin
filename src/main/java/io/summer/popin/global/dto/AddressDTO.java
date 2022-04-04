package io.summer.popin.global.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String addressName;
    private String region1depth;
    private String region2depth;
    private String region3depth;
    private String roadName;
    private Integer mainBuildingNo;
    private Integer subBuildingNo;
    private String buildingName;
    private Integer zoneNo;
    private Integer coordX;
    private Integer coordY;
}
