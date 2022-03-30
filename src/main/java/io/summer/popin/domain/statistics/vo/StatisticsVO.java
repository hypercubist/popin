package io.summer.popin.domain.statistics.vo;

import lombok.Data;


@Data
public class StatisticsVO {
    private int hostNo;
    private int placeNo;
    private int guestCount;
    private int income;
    private String recordDate;
}
