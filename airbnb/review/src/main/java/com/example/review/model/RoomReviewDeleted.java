package com.example.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Accessors(chain = true)
public class RoomReviewDeleted {
    private Long id;
}
