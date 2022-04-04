package io.summer.popin.domain.member.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.summer.popin.domain.member.dto.KakaoGetTokenResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Service
public class KakaoLoginServiceImpl implements KakaoLoginService{


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
    public String getKakaoAccessToken(String code) {

        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);    //서버로 데이터 출력

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuffer postURL = new StringBuffer();
            postURL.append("grant_type=authorization_code");
            postURL.append("&client_id=" + "6f95f0f12833233ff0c1b5321df44fb4");
            postURL.append("&redirect_uri=http://localhost:8100/login/kakao/callback");
            postURL.append("&code=" + code);
            bufferedWriter.write(postURL.toString());
            bufferedWriter.flush();   //버퍼에 남아있는 데이터 모두 출력

            int responseCode = conn.getResponseCode();
            log.info("responseCode = {}", responseCode);

            //요청으로 얻은 제이슨 타입 responseBody 읽기
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String response = "";

            while ((line = bufferedReader.readLine()) != null) {

                response += line;
            }
            log.info("response Body = {}", response);

            //읽어온 json객체 파싱
//            JsonParser parser = new JsonParser();
//            JsonElement element = parser.parse(response);

            ObjectMapper objectMapper = new ObjectMapper();

            KakaoGetTokenResponseDTO json = objectMapper.readValue(response, KakaoGetTokenResponseDTO.class);
            log.info("KakaoGetTokenResponseDTO = {}", json);

            access_Token  = json.getAccess_token();
            refresh_Token = json.getRefresh_token();

            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            log.error("getKakaoAccessToken = {}", e.getMessage());
        }

        return access_Token;
    }



}
