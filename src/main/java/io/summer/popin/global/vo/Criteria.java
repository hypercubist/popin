package io.summer.popin.global.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Criteria{

    private int pageNum;
    private int amount;

    public Criteria() {
        this(1, 10);
    }
}
