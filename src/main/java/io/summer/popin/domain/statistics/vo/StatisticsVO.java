package io.summer.popin.domain.statistics.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;


@Data
@Alias("Statistics")
public class StatisticsVO {
    private int hostNo;
    private Long placeNo;
    private Long guestCount;
    private Long income;
    private Date recordDate;
}
