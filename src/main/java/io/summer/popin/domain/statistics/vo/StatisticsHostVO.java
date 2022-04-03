package io.summer.popin.domain.statistics.vo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class StatisticsHostVO {
    private Integer hostNo;
    private Integer reservationCountToday;
    private Integer reservationCountTotal;
    private Integer incomeToday;
    private Integer incomeTotal;
    private LocalDateTime recordDate;
    private LocalDateTime recordDay;
}

