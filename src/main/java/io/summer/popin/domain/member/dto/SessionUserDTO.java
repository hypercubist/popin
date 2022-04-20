package io.summer.popin.domain.member.dto;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class SessionUserDTO implements Serializable {

    private Long no;
    private Long id;
    private String nickname;
    private String role;
    private String email;
    private String profileUrl;

    public SessionUserDTO(LoginMemberInfoDTO loginMemberInfoDTO) {

        this.no = loginMemberInfoDTO.getNo();
        this.id = loginMemberInfoDTO.getId();
        this.nickname = loginMemberInfoDTO.getNickname();
        this.role = loginMemberInfoDTO.getRole();
        this.email = loginMemberInfoDTO.getEmail();
        this.profileUrl = loginMemberInfoDTO.getProfileUrl();

    }
}
