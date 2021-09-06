package com.example.review.support.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewRequest {
    private String commentBy;

    private String commentTo;

    private String description;

    private Double score;
}
