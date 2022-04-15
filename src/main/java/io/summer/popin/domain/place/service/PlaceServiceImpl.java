package io.summer.popin.domain.place.service;

import io.summer.popin.domain.model.ResourceKind;
import io.summer.popin.domain.place.dao.PlaceMapper;
import io.summer.popin.domain.place.dto.*;
import io.summer.popin.domain.place.vo.PlaceVO;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public PlaceDetailResponseDTO getPlaceDetail(Long placeNo) {

        return placeMapper.findOneByNo(placeNo);
    }

    @Override
    public List<String> getImageUrls(Long placeNo) {
        return urlMapper.findUrlByPlaceNo(ResourceKind.PLACE.ordinal(),placeNo);
    }

    @Override
    public String getThumbnailUrl(Long placeNo) {
        return urlMapper.findUrlByPlaceNo(ResourceKind.PLACE_THUMBNAIL.ordinal(),placeNo).get(0);
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
    public KakaoLocalRoadAddressDTO getRoadAddress(Double coordX, Double coordY) {

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

        if (kakaoLocalDTO.getMeta().getTotal_count() > 0) {
            KakaoLocalRoadAddressDTO roadAddress = kakaoLocalDTO.getDocuments()[0].getRoad_address();
            //도로명주소가 없을 가능성
            return roadAddress;
        }else return null;

    }

    @Transactional
    @Override
    public Long registerPlace(PlaceRegisterDTO registerDTO) {

        PlaceVO place = new PlaceVO();

        place.setName(registerDTO.getPlaceName());
        place.setHostNo(registerDTO.getHostNo());
        place.setPlaceKindCode(registerDTO.getPlaceKindCode());
        place.setDescription(registerDTO.getDescription());
        place.setPriceHigh(registerDTO.getPriceHigh());
        place.setCheckinTimeStart(registerDTO.getCheckinTimeStart());
        place.setCheckinTimeEnd(registerDTO.getCheckinTimeEnd());
        place.setCheckoutTimeStart(registerDTO.getCheckoutTimeStart());
        place.setCheckoutTimeEnd(registerDTO.getCheckoutTimeEnd());
        place.setAddressName(registerDTO.getAddressName());
        place.setCoordX(registerDTO.getCoordX());
        place.setCoordY(registerDTO.getCoordY());
        place.setRegion1depth(registerDTO.getRegion1Depth());
        place.setRegion2depth(registerDTO.getRegion2Depth());
        place.setRegion3depth(registerDTO.getRegion3Depth());
        place.setRoadName(registerDTO.getRoadName());
        place.setMainBuildingNo(registerDTO.getMainBuildingNo());
        place.setSubBuildingNo(registerDTO.getSubBuildingNo());
        place.setBuildingName(registerDTO.getBuildingName());
        place.setRoomCount(registerDTO.getRoomCount());
        place.setBathroomCount(registerDTO.getBathroomCount());
        place.setBedSingle(registerDTO.getBedSingle());
        place.setBedDouble(registerDTO.getBedDouble());
        place.setBedQueen(registerDTO.getBedQueen());
        place.setBedKing(registerDTO.getBedKing());
        place.setKitchen(registerDTO.getKitchen());
        place.setParking(registerDTO.getParking());
        place.setWifi(registerDTO.getWifi());
        place.setBalcony(registerDTO.getBalcony());
        place.setPool(registerDTO.getPool());
        place.setAirConditioner(registerDTO.getAirConditioner());
        place.setBathtub(registerDTO.getBathtub());
        place.setCrib(registerDTO.getCrib());
        place.setTv(registerDTO.getTv());
        place.setCoffeeMachine(registerDTO.getCoffeeMachine());
        place.setPc(registerDTO.getPc());
        place.setBlackBoard(registerDTO.getBlackBoard());
        place.setBeamProject(registerDTO.getBeamProject());
        place.setBalloon(registerDTO.getBalloon());
        place.setDiningTable(registerDTO.getDiningTable());
        place.setLamp(registerDTO.getLamp());
        place.setKitchenTools(registerDTO.getKitchenTools());
        place.setMaxGuest(registerDTO.getMaxGuest());

        if(placeMapper.insertOne(place) == 1) {
            return place.getNo();
        } else {
            return null;
        }


    }

    @Override
    public List<MyPlaceDTO> getMyPlaces(Long hostNo) {
        return placeMapper.findPlaceListByHostNo(ResourceKind.PLACE_THUMBNAIL.ordinal(), hostNo); //집 정보와 썸네일 한번에 가져오기
    }

    @Override
    public Integer getMyPlacesCount(Long hostNo) {
        return placeMapper.getPlacesCountByHostNo(hostNo);
    }
}
