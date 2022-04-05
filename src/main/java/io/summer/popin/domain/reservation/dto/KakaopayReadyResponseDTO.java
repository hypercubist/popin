package io.summer.popin.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class KakaopayReadyResponseDTO {

    private String tid;
    private String next_redirect_pc_url;
    @DateTimeFormat(pattern="yyyy-MM-dd`T`HH:mm:ss")
    private LocalDateTime created_at;
    private String partner_order_id;
}
