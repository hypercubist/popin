package io.summer.popin.domain.statistics.controller;

import io.summer.popin.domain.statistics.dto.StatisticsDTO;
import io.summer.popin.domain.statistics.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StatisticsApiController {

    private final StatisticsService statisticsService;

    @PostMapping("/statistics/{hostNo}")
    public ResponseEntity<List<StatisticsDTO>> chartInfo(@PathVariable Integer hostNo, Model model){
        return new ResponseEntity<List<StatisticsDTO>>(statisticsService.getChartData(hostNo), HttpStatus.OK);

    }


}
