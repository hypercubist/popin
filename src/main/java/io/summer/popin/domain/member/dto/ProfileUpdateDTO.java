package io.summer.popin.domain.member.dto;

import lombok.Data;

@Data
public class ProfileUpdateDTO {

    private Long no;
    private String email;
    private String introduction;
    private String phoneNumber;
}
