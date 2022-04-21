package io.summer.popin.domain.member.dto;

import lombok.Data;

@Data
public class MemberProfileResponseDTO {

    //member
    private Long memberNo;
    private String name;
    private String introduction;
    private String joinYear;
    private Integer emailCertificated;
    private Integer phoneCertificated;

}
