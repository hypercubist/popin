package io.summer.popin.global.dto;

import io.summer.popin.global.vo.Criteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {

    private int startPage;
    private int endPage;
    private boolean prev, next;

    private int total;
    private Criteria cri;

    public PageDTO(Criteria cri, int total) {
        this.cri = cri;
        if (total == 0) {
            total = 1;
        }
        this.total = total;

        this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
        this.startPage = this.endPage - 9;
        int realEndPage = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
        if (realEndPage < this.endPage) {
            this.endPage = realEndPage;
        }
        this.prev = this.startPage > 1;
        this.next = this.endPage < realEndPage;
    }
}
