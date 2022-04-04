package io.summer.popin.domain.member.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KakaoLoginServiceImpl implements KakaoLoginService{


    @Override
    public String getKakaoAuthCodeRequestURL() {

        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + "6f95f0f12833233ff0c1b5321df44fb4");
        url.append("&redirect_uri=https://localhost:8100/login/kakao/callback");
        url.append("&response_type=code");

        return url.toString();
    }

    @Override
    public void getKakaoAuthCode(String code) {

        log.info("kakao Code = {}", code);
    }


}
