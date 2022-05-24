package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dao.ManagementMapper;
import io.summer.popin.domain.management.dto.MemberCountDTO;
import io.summer.popin.domain.management.dto.PlaceCountDTO;
import io.summer.popin.domain.management.dto.ReservationCountDTO;
import io.summer.popin.domain.model.PlaceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService{

    private final ManagementMapper managementMapper;

    @Override
    public MemberCountDTO getMemberCount() {
        MemberCountDTO countDTO = new MemberCountDTO();
        countDTO.setMemberTotalCount(managementMapper.getMemberTotalCount());
        countDTO.setTodayJoinCount(managementMapper.getTodayJoinCount());
        return countDTO;
    }

    @Override
    public PlaceCountDTO getPlaceCount() {
        PlaceCountDTO countDTO = new PlaceCountDTO();
        countDTO.setPlaceTotalCount(managementMapper.getPlaceCountByStatus());
        countDTO.setPlacePendingCount(managementMapper.getPlaceCountByStatus(PlaceStatus.PENDING));
        countDTO.setPlaceActivatedCount(managementMapper.getPlaceCountByStatus(PlaceStatus.ACTIVATED));
        countDTO.setPlaceDeactivatedCount(managementMapper.getPlaceCountByStatus(PlaceStatus.DEACTIVATED));
        return countDTO;
    }

    @Override
    public ReservationCountDTO getReservationCount() {
        ReservationCountDTO countDTO = new ReservationCountDTO();
        countDTO.setTodayReservedCount(managementMapper.getTodayReservedCount());
        countDTO.setBeforeCheckinCount(managementMapper.getBeforeCheckinCount());
        countDTO.setNowStayingCount(managementMapper.getNowStayingCount());
        return countDTO;
    }
}
