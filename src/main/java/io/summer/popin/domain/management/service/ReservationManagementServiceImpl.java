package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dao.ManagementMapper;
import io.summer.popin.domain.management.dto.ReservationCountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationManagementServiceImpl implements ReservationManagementService{

    private final ManagementMapper managementMapper;

    @Override
    public ReservationCountDTO getReservationCount() {
        ReservationCountDTO countDTO = new ReservationCountDTO();
        countDTO.setTodayReservedCount(managementMapper.getTodayReservedCount());
        countDTO.setBeforeCheckinCount(managementMapper.getBeforeCheckinCount());
        countDTO.setNowStayingCount(managementMapper.getNowStayingCount());
        return countDTO;
    }

    @Override
    public List<String> getReservationStatusList() {
        return managementMapper.getReservationStatusList();
    }
}
