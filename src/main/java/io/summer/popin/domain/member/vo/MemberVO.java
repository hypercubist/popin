package io.summer.popin.domain.member.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class MemberVO {

    private Long no;
    private String name;
    private String email;
    private String phoneNumber;
    private Date joinDate;
    private Integer classCode;
    private Integer socialKakao;
    private Integer socialGitHub;
    private Integer socialGoogle;
    private Integer emailCertificated;
    private Integer phoneCertificated;



}
