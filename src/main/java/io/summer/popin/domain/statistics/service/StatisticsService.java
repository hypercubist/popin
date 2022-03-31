package io.summer.popin.domain.statistics.service;

import io.summer.popin.domain.statistics.vo.StatisticsHostVO;

import java.util.List;


public interface StatisticsService {

    public List<StatisticsHostVO> showStatistics(Integer hostNo);

    public StatisticsHostVO getChartData(Integer hostNo);

}
