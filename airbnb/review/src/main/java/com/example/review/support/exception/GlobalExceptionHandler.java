package com.example.review.support.exception;

import com.example.review.support.error.ReviewError;
import com.example.review.support.response.AirbnbReviewResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ReviewException.class)
    public AirbnbReviewResponse<?> reviewException(ReviewException e){
        ReviewError error = e.getReviewError();
        return new AirbnbReviewResponse<>(error.getStatus(),error.getDescription());
    }
}
