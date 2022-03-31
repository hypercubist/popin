package io.summer.popin.domain.statistics.controller;

import io.summer.popin.domain.statistics.service.StatisticsService;
import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StatisticsApiController {

    private final StatisticsService statisticsService;

    @PostMapping("/statistics/{hostNo}")
    public ResponseEntity<StatisticsHostVO> chartInfo(@PathVariable Integer hostNo){
        return new ResponseEntity<StatisticsHostVO>(statisticsService.getChartData(hostNo), HttpStatus.OK) ;
    }


}
