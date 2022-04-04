package io.summer.popin.persistence;

import io.summer.popin.domain.statistics.dao.StatisticsMapper;
import io.summer.popin.domain.statistics.service.SchedulerService;
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
    SchedulerService schedulerService;

    @Autowired
    StatisticsMapper statisticsMapper;

    @DisplayName("호스트 번호 조회")
    @Test
    public void chartTest(){
//        List<String> list = schedulerService.statisticsHostList();
//            for (String i : list){
//                log.info(i.getHostNo().toString());
//        }
    }

    @DisplayName("배치 프로그램")
    @Test
    public void insertTest(){
        List<String> list =  statisticsMapper.statisticsHostList();

        for (String i: list){
            log.info(i);
            statisticsMapper.statisticsScheduler(i);
        }
    }


}
