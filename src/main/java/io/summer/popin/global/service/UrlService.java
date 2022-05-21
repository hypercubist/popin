package io.summer.popin.global.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Value("${kakaomaps.host}")
    private String kakaomapHost;

    @Value("${kakaomaps.appkey}")
    private String kakaomapsAppKey;

    @Value("${kakaomaps.library}")
    private String kakaomapsLibrary;

    public String getKakaoMapsSource() {
        return kakaomapHost+kakaomapsAppKey+kakaomapsLibrary;
    }
}
