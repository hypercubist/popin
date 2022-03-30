package io.summer.popin.persistence;

import io.summer.popin.domain.statistics.controller.StatisticsController;
import io.summer.popin.domain.statistics.service.StatisticsService;
import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class StatisticsMapperTest {

    @Autowired
    StatisticsController statisticsController;

    @Autowired
    StatisticsService statisticsService;

    @DisplayName("개인별 통계")
    @Test
    public void test(){
        List<StatisticsHostVO> list =  statisticsController.individualStatistics();
        for (StatisticsHostVO i : list){
            log.info(String.valueOf(i));
        }
    }

    @DisplayName("차트에 표시 할 데이터")
    @Test
    public void chartTest(){
        StatisticsHostVO statisticsVO = statisticsService.getChartData(1);
            log.info("호스트 번호"+statisticsVO.getHostNo());
            log.info("현재까지 총 수입"+statisticsVO.getIncomeTotal());
            log.info("현재 날짜"+statisticsVO.getRecordDate());
    }


}
