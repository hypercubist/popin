package io.summer.popin.domain.statistics.dao;

import io.summer.popin.domain.statistics.vo.StatisticsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {

    public List<StatisticsVO> showStatisticsByHostNo(Integer hostNo);

    public StatisticsVO statisticsChart(Integer hostNo);

}
