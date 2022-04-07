package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.PlaceKindDTO;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService{

    private final PlaceMapper placeMapper;
    private final UrlMapper urlMapper;

    @Value("${kakaomaps.host}")
    private String kakaomapHost;

    @Value("${kakaomaps.appkey}")
    private String kakaomapsAppKey;

    @Value("${kakaomaps.library}")
    private String kakaomapsLibrary;

    @Override
    public PlaceDetailResponseDTO getPlaceDetail(int placeNo) {
        return placeMapper.findOneByNo(placeNo);
    }

    @Override
    public List<String> getImageUrls(int placeNo) {
        return urlMapper.findListListByPlaceNo(placeNo);
    }

    @Override
    public List<PlaceKindDTO> getPlaceKinds() {
        return placeMapper.findKindMap();
    }

    @Override
    public String getKakaoMapsSource() {
        return kakaomapHost+kakaomapsAppKey+kakaomapsLibrary;
    }
}
