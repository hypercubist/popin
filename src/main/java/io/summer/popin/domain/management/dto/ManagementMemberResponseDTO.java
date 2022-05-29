package io.summer.popin.domain.management.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ManagementMemberResponseDTO {

    private Integer rn;
    private Integer no;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate joinDate;
    private String memberClass;
}
