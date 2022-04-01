package io.summer.popin.domain.statistics.dao;

import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {

    //호스트 통계 테이블에서 개인정보
    public List<StatisticsHostVO> showStatisticsByHostNo(Integer hostNo);

    //통계 낼때 필요한 데이터
    public List<StatisticsHostVO> statisticsChart(Integer hostNo);

    //호스트가 있는지 조회
    public List<StatisticsHostVO> statisticsHostList();

    //스케줄러 돌릴 호스트별로 통계 테이블에 저장한다
    public boolean statisticsScheduler();
}
