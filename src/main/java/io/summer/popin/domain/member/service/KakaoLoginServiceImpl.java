package io.summer.popin.domain.member.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.summer.popin.domain.member.dao.MemberMapper;
import io.summer.popin.domain.member.dto.KakaoGetTokenResponseDTO;
import io.summer.popin.domain.member.dto.KakaoGetUserInfoJsonResponseDTO;
import io.summer.popin.domain.member.dto.KakaoUserDTO;
import io.summer.popin.domain.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class KakaoLoginServiceImpl implements KakaoLoginService{

    private final MemberMapper memberMapper;

    @Override
    public String getKakaoAuthCodeRequestURL() {

        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + "6f95f0f12833233ff0c1b5321df44fb4");
        url.append("&redirect_uri=http://localhost:8100/login/kakao/callback");
        url.append("&response_type=code");

        return url.toString();
    }

    @Override
    public String getKakaoAccessToken(String code, HttpSession session) {

        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);    //아웃풋 스트림으로 데이터 전송

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuffer postURL = new StringBuffer();
            postURL.append("grant_type=authorization_code");
            postURL.append("&client_id=" + "6f95f0f12833233ff0c1b5321df44fb4");
            postURL.append("&redirect_uri=http://localhost:8100/login/kakao/callback");
            postURL.append("&code=" + code);
            bufferedWriter.write(postURL.toString());
            bufferedWriter.flush();   //버퍼에 남아있는 데이터 모두 출력

            int responseCode = conn.getResponseCode();
            log.info("getKakaoAccessTokenResponseCode = {}", responseCode);

            //요청으로 얻은 제이슨 타입 responseBody 읽기
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String response = "";

            while ((line = bufferedReader.readLine()) != null) {

                response += line;
            }
            log.info("response Body = {}", response);

            ObjectMapper objectMapper = new ObjectMapper();

            KakaoGetTokenResponseDTO json = objectMapper.readValue(response, KakaoGetTokenResponseDTO.class);
            log.info("KakaoGetTokenResponseDTO = {}", json);

            access_Token  = json.getAccess_token();
            refresh_Token = json.getRefresh_token();

            log.info("access_Token = {}", access_Token);
            log.info("refresh_Token = {}", refresh_Token);

            session.setAttribute("access_Token", access_Token);

            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            log.error("getKakaoAccessToken = {}", e.getMessage());
        }

        return access_Token;
    }


    @Override
    public KakaoUserDTO getUserInfo(String access_Token, HttpSession session) {

        KakaoUserDTO userDTO = new KakaoUserDTO();

        String reqURL = "https://kapi.kakao.com/v2/user/me";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);  //요청 헤더

            int responseCode = conn.getResponseCode();
            log.info("getUserInfoResponseCode = {}", responseCode);

            //요청해서 얻은 제이슨 타입 메세지 읽기
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String response = "";

            while ((line = bufferedReader.readLine()) != null) {

                response += line;
            }
            log.info("GetUserInfoResponse Body = {}", response);

            //받은 제이슨 parsing
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  //알 수 없는 프로퍼티가 있을 때 예외가 발생할 수 있는데 이를 비활성화.

            KakaoGetUserInfoJsonResponseDTO jsonResponseDTO = objectMapper.readValue(response, KakaoGetUserInfoJsonResponseDTO.class);
            log.info("KakaoGetUserInfoJsonResponseDTO = {}", jsonResponseDTO);

            boolean hasEmail = jsonResponseDTO.getKakao_account().isHas_email();

            if(hasEmail) {
                session.setAttribute("email", jsonResponseDTO.getKakao_account().getEmail());
            }

            userDTO.setId(jsonResponseDTO.getId());
            userDTO.setNickname(jsonResponseDTO.getProperties().getNickname());
            userDTO.setEmail(jsonResponseDTO.getKakao_account().getEmail());

            bufferedReader.close();

        } catch (IOException e) {
            log.error("getUserInfo = {}", e.getMessage());
        }
        return userDTO;
    }

    @Override
    public KakaoUserDTO kakaoLogin(KakaoUserDTO userDTO) {

        //db에 멤버 정보가 없으면 저장
        if(memberMapper.checkId(userDTO.getId()) != 1) {
            memberMapper.saveMember(userDTO);
        }

        return userDTO;
    }


}
