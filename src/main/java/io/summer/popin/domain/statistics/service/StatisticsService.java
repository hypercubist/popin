package io.summer.popin.domain.statistics.service;

import io.summer.popin.domain.statistics.vo.StatisticsVO;

import java.util.List;


public interface StatisticsService {

    public List<StatisticsVO> showStatistics(int hostNo);

    public StatisticsVO statisticsChart();

}
