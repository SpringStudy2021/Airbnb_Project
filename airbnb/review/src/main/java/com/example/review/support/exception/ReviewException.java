package com.example.review.support.exception;

import com.example.review.support.error.ReviewError;
import lombok.Getter;

@Getter
public class ReviewException extends RuntimeException{
    private ReviewError reviewError;

    public ReviewException(ReviewError reviewError){
        super(reviewError.getDescription());
        this.reviewError=reviewError;
    }
}
