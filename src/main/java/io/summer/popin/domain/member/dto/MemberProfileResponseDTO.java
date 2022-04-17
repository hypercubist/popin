package io.summer.popin.domain.member.dto;

import lombok.Data;

@Data
public class MemberProfileResponseDTO {

    //member
    private Long no;
    private String name;
    private String joinYear;
    private Integer emailCertificated;
    private Integer phoneCertificated;

}