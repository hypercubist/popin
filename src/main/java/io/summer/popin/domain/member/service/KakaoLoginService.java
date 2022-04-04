package io.summer.popin.domain.member.service;

public interface KakaoLoginService {

    String getKakaoAuthCodeRequestURL();

    String getKakaoAccessToken(String code);
}
