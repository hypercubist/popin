package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dto.KakaoGetUserInfoJsonResponseDTO;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface KakaoLoginService {

    String getKakaoAuthCodeRequestURL();

    String getKakaoAccessToken(String code, HttpSession session);

    HashMap<String, Object>  getUserInfo(String access_Token, HttpSession session);

    int checkMember(HashMap<String, Object> userInfo);
}
