package io.summer.popin.domain.statistics.dto;

import lombok.Data;

@Data
public class StatisticsDTO {
    private Integer hostNo;
    private Integer reservationCountToday;
    private Integer reservationCountTotal;
    private Integer incomeToday;
    private Integer incomeTotal;
    private String recordDate;
    private String recordDay;

}
