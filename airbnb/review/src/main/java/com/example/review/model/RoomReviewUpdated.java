package com.example.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class RoomReviewUpdated {
    private Long id;

    private String description;

    private Double score;

    private LocalDateTime commentDate;
}
