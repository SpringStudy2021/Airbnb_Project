package com.example.review.controller;

import com.example.review.aggregate.ReviewService;
import com.example.review.model.CustomerReviewCreated;
import com.example.review.model.HostReviewCreated;
import com.example.review.model.Review;
import com.example.review.model.RoomReviewCreated;
import com.example.review.support.response.AirbnbReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/room")
    public AirbnbReviewResponse createRoomReview(@RequestBody RoomReviewCreated roomReviewCreated){
        // TODO: 예외처리 추가 ( 사용자 있는지 확인 + 방 있는지 확인)
        String result = reviewService.createRoomReview(roomReviewCreated);
        return new AirbnbReviewResponse(result);
    }

    @PostMapping("/host")
    public AirbnbReviewResponse createHostReview(@RequestBody HostReviewCreated hostReviewCreated){
        // TODO: 예외처리 추가 ( 사용자 있는지 확인 host & customer )
        String result = reviewService.createHostReview(hostReviewCreated);
        return new AirbnbReviewResponse(result);
    }

    @PostMapping("/customer")
    public AirbnbReviewResponse createCustomerReview(@RequestBody CustomerReviewCreated customerReviewCreated){
        // TODO: 예외처리 추가 ( 사용자 있는지 확인 host & customer )
        String result = reviewService.createCustomerReview(customerReviewCreated);
        return new AirbnbReviewResponse(result);
    }


}
