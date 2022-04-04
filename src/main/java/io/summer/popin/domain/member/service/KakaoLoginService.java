package io.summer.popin.domain.member.service;

public interface KakaoLoginService {

    String getKakaoAuthCodeRequestURL();

    void getKakaoAuthCode(String code);
}
