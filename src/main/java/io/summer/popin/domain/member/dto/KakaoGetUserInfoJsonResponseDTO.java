package io.summer.popin.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KakaoGetUserInfoJsonResponseDTO {

    private Long id;
    @DateTimeFormat(pattern="yyyy-MM-dd`T`HH:mm:ss`Z`")
    private LocalDateTime connected_at;
    private KakaoGetUserInfoJsonKakaoAccountDTO kakao_account;
    private KakaoGetUserInfoJsonPropertiesDTO properties;
}
