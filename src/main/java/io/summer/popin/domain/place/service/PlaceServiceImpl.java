package io.summer.popin.domain.place.service;

import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.KakaoLocalDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.PlaceKindDTO;
import io.summer.popin.global.dao.UrlMapper;
import io.summer.popin.global.dto.AddressDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
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

    @Value("${kakaolocal.host}")
    private String kakaolocalHost;

    @Value("${kakaolocal.format}")
    private String kakaolocalFormat;

    @Value("${kakaolocal.restapi-key}")
    private String kakaolocalRestapiKey;

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

    @Override
    public AddressDTO getAddress(Double coordX, Double coordY) {

        String requestUrl = kakaolocalHost + kakaolocalFormat + "?x=" + coordX + "&y=" + coordY;
        log.info("URL={}", requestUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + kakaolocalRestapiKey);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        KakaoLocalDTO kakaoLocalDTO = restTemplate.postForObject(requestUrl, httpEntity, KakaoLocalDTO.class);
        log.info("LOCAL={}", kakaoLocalDTO);


        AddressDTO addressDTO = new AddressDTO();

        return addressDTO;
    }
}
