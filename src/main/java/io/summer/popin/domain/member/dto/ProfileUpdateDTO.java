package io.summer.popin.domain.member.dto;

import lombok.Data;

@Data
public class ProfileUpdateDTO {

    private Long no;
    private String name;
    private String email;
    private String phoneNumber;
}