package io.summer.popin.domain.search.vo;

import io.summer.popin.domain.search.dto.Criteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {
    private int startPage, endPage;
    private boolean prev, next;

    private int total;
    private Criteria criteria;

    public PageVO(Criteria criteria, int total) {
        this.criteria = criteria;
        this.total = total;
        this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
        this.startPage = endPage - 9;
        this.prev = this.startPage > 1;
        int realEnd = (int) (Math.ceil((total * 1.0) / criteria.getAmount()));
        this.endPage = realEnd < endPage ? realEnd : endPage;
        this.next = this.endPage < realEnd;
    }


}
