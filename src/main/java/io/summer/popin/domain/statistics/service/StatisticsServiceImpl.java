package io.summer.popin.domain.statistics.service;

import io.summer.popin.domain.statistics.dao.StatisticsMapper;
import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService{

    private final StatisticsMapper statisticsMapper;

    public List<StatisticsHostVO> showStatistics(Integer hostNo){
      return statisticsMapper.showStatisticsByHostNo(hostNo);
    }

    @Override
    public List<StatisticsHostVO> getChartData(Integer hostNo) {
        return statisticsMapper.statisticsChart(hostNo);
    }

}
