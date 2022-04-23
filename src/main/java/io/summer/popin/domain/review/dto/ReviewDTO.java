package io.summer.popin.domain.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ReviewDTO {

    private Long guestNo;
    private String guestName;
    private String guestThumbnailUrl;
    private String content;
    private LocalDate writingDate;
}
