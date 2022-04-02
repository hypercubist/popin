package io.summer.popin.domain.member.dto;

import lombok.Data;


@Data
public class ProfileResponseDTO {

    private Long no;
    private String name;
    private String email;
    private String phoneNumber;
    private String className;
    private String joinYear;
    private Integer emailCertificated;
    private Integer phoneCertificated;
}
