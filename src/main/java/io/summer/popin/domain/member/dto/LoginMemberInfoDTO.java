package io.summer.popin.domain.member.dto;

import lombok.*;

@ToString
@Getter
public class LoginMemberInfoDTO {

    private Long id;
    private String nickname;
    private String email;
    private String memberClass;


    @Builder
    public LoginMemberInfoDTO(Long id, String nickname, String email, String memberClass) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.memberClass = memberClass;
    }

    public LoginMemberInfoDTO update(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;

        return this;
    }

}
