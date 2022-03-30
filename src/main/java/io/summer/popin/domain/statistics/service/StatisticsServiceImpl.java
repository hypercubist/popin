package io.summer.popin.domain.statistics.service;

import io.summer.popin.domain.statistics.dao.StatisticsMapper;
import io.summer.popin.domain.statistics.vo.StatisticsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService{

    private final StatisticsMapper statisticsMapper;

    public List<StatisticsVO> showStatistics(int hostNo){
      return statisticsMapper.showStatisticsByHostNo(hostNo);
    }

    @Override
    public StatisticsVO statisticsChart() {
        return statisticsMapper.statisticsChart();
    }

    ;

}
