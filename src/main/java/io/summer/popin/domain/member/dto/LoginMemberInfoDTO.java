package io.summer.popin.domain.member.dto;

import lombok.*;

@ToString
@Getter
@Setter
public class LoginMemberInfoDTO {

    private Long no;
    private Long id;
    private String nickname;
    private String email;
    private String role;
    private String profileUrl;


    @Builder
    public LoginMemberInfoDTO(Long no, Long id, String nickname, String email, String role) {
        this.no = no;
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
    }

    public LoginMemberInfoDTO update(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;

        return this;
    }

}
