package io.summer.popin.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class KakaopayApproveResponseDTO {

    private String aid;
    private String tid;
    private String cid;
    private String sid;
    private String partner_order_id;
    private String partner_user_id;
    private String payment_method_type;
    private AmountDTO amount;
    private KakaopayCardInfoDTO card_info;
    private String item_name;
    private String item_code;
    private Integer quantity;
    private LocalDateTime create_at;
    private LocalDateTime approve_at;
    private String payload;

}
