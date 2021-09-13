package com.example.review.support.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResponse {
    private Long id;

    private String commentBy;

    private String commentTo;

    private String description;

    private Double score;

    private LocalDateTime commentDate;

}
