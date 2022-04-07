package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dto.KakaoGetUserInfoJsonResponseDTO;
import io.summer.popin.domain.member.dto.KakaoUserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface KakaoLoginService {

    String getKakaoAuthCodeRequestURL();

    String getKakaoAccessToken(String code, HttpSession session);

    KakaoUserDTO getUserInfo(String access_Token, HttpSession session);

    KakaoUserDTO kakaoLogin(KakaoUserDTO userDTO);

}
