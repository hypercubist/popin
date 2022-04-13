package io.summer.popin.domain.statistics.vo;

import lombok.Data;

import java.time.LocalDate;


@Data
public class StatisticsHostVO {
    private Integer hostNo;
    private Integer reservationCountToday;
    private Integer reservationCountTotal;
    private Integer incomeToday;
    private Integer incomeTotal;
    private LocalDate recordDate;
    private LocalDate recordDay;
}

