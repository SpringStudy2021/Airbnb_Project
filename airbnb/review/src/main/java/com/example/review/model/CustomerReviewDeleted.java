package com.example.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class CustomerReviewDeleted {
    private Long id;
}
