package io.summer.popin.domain.place.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoLocalTotalAddressDTO {

    KakaoLocalAddressDTO address;
    KakaoLocalRoadAddressDTO road_address;
}
