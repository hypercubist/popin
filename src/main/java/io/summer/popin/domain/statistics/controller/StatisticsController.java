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

    @GetMapping("/juntest")
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
