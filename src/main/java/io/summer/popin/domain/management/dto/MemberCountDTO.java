package io.summer.popin.domain.management.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberCountDTO {

    private Integer memberTotalCount;
    private Integer todayJoinCount;
}
