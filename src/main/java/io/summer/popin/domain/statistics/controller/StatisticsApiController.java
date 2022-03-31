package io.summer.popin.domain.statistics.controller;

import io.summer.popin.domain.statistics.service.StatisticsService;
import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StatisticsApiController {

    private final StatisticsService statisticsService;

    @PostMapping("/statistics")
    public ResponseEntity<List<StatisticsHostVO>> chartInfo(Integer hostNo){
        return new ResponseEntity<List<StatisticsHostVO>>(statisticsService.getChartData(1), HttpStatus.OK) ;
    }


}
