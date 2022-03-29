package io.summer.popin.domain.statistics.controller;

import io.summer.popin.domain.statistics.service.StatisticsService;
import io.summer.popin.domain.statistics.vo.StatisticsVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/")
//    @Scheduled(cron = "1 * * * * 2022") //초 분 시 일 월 요일 년(선택)에 해당 메서드 호출
    public List<StatisticsVO> individualStatistics(){
        List<StatisticsVO> list =  statisticsService.showStatistics(1);
        for (StatisticsVO i : list){
            log.info(String.valueOf(i));
        }
        return statisticsService.showStatistics(1);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
