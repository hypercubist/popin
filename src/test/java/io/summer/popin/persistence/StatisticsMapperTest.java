package io.summer.popin.persistence;

import io.summer.popin.domain.statistics.service.SchedulerService;
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
    SchedulerService schedulerService;

    @DisplayName("호스트 번호 조회")
    @Test
    public void chartTest(){
        List<StatisticsHostVO> list = schedulerService.statisticsHostList();
            for (StatisticsHostVO i : list){
                log.info(i.getHostNo().toString());
        }
    }


}
