package io.summer.popin.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountDTO {

    private Integer total;
    private Integer tax_free;
    private Integer vat;
    private Integer point;
    private Integer discount;
}
