package com.example.review.controller;

import com.example.review.aggregate.ReviewService;
import com.example.review.domain.event.CustomerReviewCreated;
import com.example.review.domain.event.HostReviewCreated;
import com.example.review.domain.event.RoomReviewCreated;
import com.example.review.support.exception.GlobalExceptionHandler;
import com.example.review.support.request.ReviewRequest;
import com.example.review.support.response.AirbnbReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController extends GlobalExceptionHandler {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/room")
    public AirbnbReviewResponse createRoomReview(@RequestBody ReviewRequest reviewRequest){
        // TODO: 예외처리 추가 ( 사용자 있는지 확인 + 방 있는지 확인)
        String result = reviewService.createRoomReview(reviewRequest);
        return new AirbnbReviewResponse(result);
    }

    @PostMapping("/host")
    public AirbnbReviewResponse createHostReview(@RequestBody ReviewRequest reviewRequest){
        // TODO: 예외처리 추가 ( 사용자 있는지 확인 host & customer )
        String result = reviewService.createHostReview(reviewRequest);
        return new AirbnbReviewResponse(result);
    }

    @PostMapping("/customer")
    public AirbnbReviewResponse createCustomerReview(@RequestBody ReviewRequest reviewRequest){
        // TODO: 예외처리 추가 ( 사용자 있는지 확인 host & customer )
        String result = reviewService.createCustomerReview(reviewRequest);
        return new AirbnbReviewResponse(result);
    }

    @DeleteMapping("/room/{id}")
    public AirbnbReviewResponse deleteRoomReview(@PathVariable(name = "id") Long id){
        String result = reviewService.deleteRoomReview(id);
        return new AirbnbReviewResponse(result);
    }

    @DeleteMapping("/host/{id}")
    public AirbnbReviewResponse deleteHostReview(@PathVariable(name = "id") Long id){
        String result = reviewService.deleteHostReview(id);
        return new AirbnbReviewResponse(result);
    }

    @DeleteMapping("/customer/{id}")
    public AirbnbReviewResponse deleteCustomerReview(@PathVariable(name = "id") Long id){
        String result = reviewService.deleteCustomerReview(id);
        return new AirbnbReviewResponse(result);
    }

}
