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
    private Long classCode;
    private Long socialKakao;
    private Long socialGitHub;
    private Long socialGoogle;
    private Long certificatedEmail;
    private Long certificatedPhone;



}
