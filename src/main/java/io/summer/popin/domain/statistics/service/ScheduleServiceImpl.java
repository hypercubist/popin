package io.summer.popin.domain.statistics.service;

import io.summer.popin.domain.statistics.dao.StatisticsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class ScheduleServiceImpl implements SchedulerService {

    private final StatisticsMapper statisticsMapper;

    public List<String> statisticsHostList() {
        return statisticsMapper.statisticsHostList();
    }

    @Scheduled(cron = "59 59 23 * * *" , zone = "Asia/Seoul")
    public void statisticsScheduler() {
        List<String> list =  this.statisticsHostList();
        for (String i: list){
            statisticsMapper.statisticsScheduler(i);
        }
        log.info("test success");
    }

}
