package io.summer.popin.domain.management.service;

import io.summer.popin.domain.management.dto.MemberCountDTO;
import io.summer.popin.domain.management.dto.PlaceCountDTO;
import io.summer.popin.domain.management.dto.ReservationCountDTO;

public interface ManagementService {

    public MemberCountDTO getMemberCount();
    public PlaceCountDTO getPlaceCount();
    public ReservationCountDTO getReservationCount();
}
