package com.example.review.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Accessors(chain = true)
public class CustomerReviewUpdated {
    private Long id;

    private String description;

    private Double score;

    private LocalDateTime commentDate;
}
