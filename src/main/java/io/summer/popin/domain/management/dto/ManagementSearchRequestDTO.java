package io.summer.popin.domain.management.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManagementSearchRequestDTO {

    private String searchTerm;
    private String status;
}
