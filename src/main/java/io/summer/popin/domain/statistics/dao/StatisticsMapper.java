package io.summer.popin.domain.statistics.dao;

import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {

    public List<StatisticsHostVO> showStatisticsByHostNo(Integer hostNo);

    public StatisticsHostVO statisticsChart(Integer hostNo);

}
