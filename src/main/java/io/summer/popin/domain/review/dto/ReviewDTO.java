package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReviewDTO {

    private Long guestNo;
    private String guestName;
    private String guestThumbnailUrl;
    private String content;
    private LocalDate writingDate;
}
