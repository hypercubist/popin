package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService{

    private final PlaceMapper placeMapper;
    private final UrlMapper urlMapper;

    @Override
    public PlaceDetailResponseDTO getPlaceDetail(int placeNo) {
        return placeMapper.findOneByNo(placeNo);
    }

    @Override
    public List<String> getImageUrls(int placeNo) {
        return urlMapper.findListByNo(placeNo);
    }
}
