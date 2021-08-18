package com.example.review.aggregate;

import com.example.review.model.CustomerReviewCreated;
import com.example.review.model.HostReviewCreated;
import com.example.review.model.Review;
import com.example.review.model.RoomReviewCreated;
import com.example.review.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public String createRoomReview(RoomReviewCreated roomReviewCreated) {
        // TODO: 예외처리 (
        System.out.println("hi");
        System.out.println("by:"+roomReviewCreated.getCommentBy());

        Review review = Review.of(roomReviewCreated.getCommentBy(),roomReviewCreated.getCommentTo(),roomReviewCreated.getDescription(),roomReviewCreated.getScore());
        reviewRepository.save(review);
        return "RoomReview Created";
    }

    public String createHostReview(HostReviewCreated hostReviewCreated) {
        // TODO: 예외처리
        Review review = Review.of(hostReviewCreated.getCommentBy(),hostReviewCreated.getCommentTo(),hostReviewCreated.getDescription(),hostReviewCreated.getScore());
        reviewRepository.save(review);
        return "HostReview Created";
    }

    public String createCustomerReview(CustomerReviewCreated customerReviewCreated) {
        Review review = Review.of(customerReviewCreated.getCommentBy(),customerReviewCreated.getCommentTo(),customerReviewCreated.getDescription(),customerReviewCreated.getScore());
        reviewRepository.save(review);
        return "HostReview Created";
    }
}
