package io.summer.popin.domain.statistics.vo;

import lombok.Data;


@Data
public class StatisticsVO {
    private Integer hostNo;
    private int placeNo;
    private int guestCount;
    private int income;
    private String recordDate;
}
