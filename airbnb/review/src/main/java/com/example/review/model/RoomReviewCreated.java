package com.example.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Accessors(chain = true)
public class RoomReviewCreated {
    private Long id;

    private String commentBy;

    private String commentTo;

    private String description;

    private Double score;

    private LocalDateTime commentDate;
}
