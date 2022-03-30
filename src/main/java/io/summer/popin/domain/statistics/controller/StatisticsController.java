package io.summer.popin.domain.statistics.controller;

import io.summer.popin.domain.statistics.service.StatisticsService;
import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@EnableScheduling // 스케줄링 관련
@Controller
@RequiredArgsConstructor
@Slf4j
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/juntest")
    public List<StatisticsHostVO> individualStatistics(){
        List<StatisticsHostVO> list =  statisticsService.showStatistics(1);
        for (StatisticsHostVO i : list){
            log.info(String.valueOf(i));
        }
        return statisticsService.showStatistics(1);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


    @Scheduled(cron = "59 59 23 * * *" , zone = "Asia/Seoul")
    public void scheduleTest() throws Exception{
        log.info("test"  + System.currentTimeMillis()/1000);
    }

}
