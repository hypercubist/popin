package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dto.ReservationCountDTO;

import java.util.List;

public interface ReservationManagementService {

    ReservationCountDTO getReservationCount();
    List<String> getReservationStatusList();
}
