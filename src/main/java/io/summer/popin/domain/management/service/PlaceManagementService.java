package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dto.PlaceCountDTO;

import java.util.List;

public interface PlaceManagementService {

    PlaceCountDTO getPlaceCount();
    List<String> getPlaceStatusList();
}
