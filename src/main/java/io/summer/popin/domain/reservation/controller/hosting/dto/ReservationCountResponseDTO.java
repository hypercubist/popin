package io.summer.popin.domain.reservation.controller.hosting.dto;

import lombok.Setter;

@Setter
public class ReservationCountResponseDTO {

    private Integer bookedCount;    //체크인 예정 수
    private Integer checkedinCount;  //체크아웃 예정 수

}
