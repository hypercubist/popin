package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dao.ManagementMapper;
import io.summer.popin.domain.management.dto.PlaceCountDTO;
import io.summer.popin.domain.model.PlaceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceManagementServiceImpl implements PlaceManagementService{

    private final ManagementMapper managementMapper;

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
    public List<String> getPlaceStatusList() {
        return managementMapper.getPlaceStatusList();
    }
}
