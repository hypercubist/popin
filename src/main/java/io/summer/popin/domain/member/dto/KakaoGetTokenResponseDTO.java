package io.summer.popin.domain.member.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KakaoGetTokenResponseDTO {

    private String token_type;
    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private Integer refresh_token_expires_in;
    private String scope;
}
