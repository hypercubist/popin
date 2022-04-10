package io.summer.popin.domain.member.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUserDTO implements Serializable {

    private Long id;
    private String nickname;
    private String email;

    public SessionUserDTO(LoginMemberInfoDTO loginMemberInfoDTO) {

        this.id = loginMemberInfoDTO.getId();
        this.nickname = loginMemberInfoDTO.getNickname();
        this.email = loginMemberInfoDTO.getEmail();
    }
}
