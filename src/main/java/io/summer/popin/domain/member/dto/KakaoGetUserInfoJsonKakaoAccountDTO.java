package io.summer.popin.domain.member.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KakaoGetUserInfoJsonKakaoAccountDTO {

    private boolean profile_nickname_needs_agreement;
    private KakaGetUserInfoJsonProfileDTO profile;
    private boolean email_needs_agreement;
    private boolean is_email_valid;
    private boolean has_email;
    private String email;
}
