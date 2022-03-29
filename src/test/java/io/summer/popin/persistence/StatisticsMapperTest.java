package io.summer.popin.persistence;

import io.summer.popin.domain.statistics.controller.StatisticsController;
import io.summer.popin.domain.statistics.dao.StatisticsMapper;
import io.summer.popin.domain.statistics.vo.StatisticsVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class StatisticsMapperTest {

    @Autowired
    StatisticsController statisticsController;

    @Test
    public void test(){
        List<StatisticsVO> list =  statisticsController.individualStatistics();
        for (StatisticsVO i : list){
            log.info(String.valueOf(i));
        }

    }


}
