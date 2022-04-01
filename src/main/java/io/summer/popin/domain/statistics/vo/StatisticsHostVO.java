package io.summer.popin.domain.statistics.vo;

import lombok.Data;


@Data
public class StatisticsHostVO {
    private Integer hostNo;
    private Integer reservationCountToday;
    private Integer reservationCountTotal;
    private Integer incomeToday;
    private Integer incomeTotal;
    private String recordDate;
    private String recordDay;
}

