package io.summer.popin.domain.member.dto;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
public class KakaoUserDTO {

    private Long id;
    private String nickname;
    private String email;
}
