package io.summer.popin.domain.statistics.service;

import io.summer.popin.domain.statistics.dto.StatisticsDTO;

import java.util.List;


public interface StatisticsService {

    public List<StatisticsDTO> showStatistics(Integer hostNo);

    public List<StatisticsDTO> getChartData(Integer hostNo);



}
