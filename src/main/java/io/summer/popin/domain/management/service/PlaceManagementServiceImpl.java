package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dao.ManagementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceManagementServiceImpl implements PlaceManagementService{

    private final ManagementMapper managementMapper;

    @Override
    public List<String> getPlaceStatusList() {
        return managementMapper.getPlaceStatusList();
    }
}
