package com.example.review.aggregate;

import com.example.review.domain.event.CustomerReviewCreated;
import com.example.review.domain.event.HostReviewCreated;
import com.example.review.domain.Review;
import com.example.review.domain.event.RoomReviewCreated;
import com.example.review.repository.ReviewRepository;
import com.example.review.support.error.ReviewError;
import com.example.review.support.exception.ReviewException;
import com.example.review.support.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public String createRoomReview(ReviewRequest reviewRequest) {
        // TODO: 예외처리
        Review review = Review.of(reviewRequest.getCommentBy(),reviewRequest.getCommentTo(),reviewRequest.getDescription(),reviewRequest.getScore());
        reviewRepository.save(review);
        return "RoomReview Created";
    }

    public String createHostReview(ReviewRequest reviewRequest) {
        // TODO: 예외처리
        Review review = Review.of(reviewRequest.getCommentBy(),reviewRequest.getCommentTo(),reviewRequest.getDescription(),reviewRequest.getScore());
        reviewRepository.save(review);
        return "HostReview Created";
    }

    public String createCustomerReview(ReviewRequest reviewRequest) {
        Review review = Review.of(reviewRequest.getCommentBy(),reviewRequest.getCommentTo(),reviewRequest.getDescription(),reviewRequest.getScore());
        reviewRepository.save(review);
        return "HostReview Created";
    }

    public String deleteRoomReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected-> {
            if(reviewSelected.getCommentTo().matches("R[0-9]*") && reviewSelected.getCommentBy().matches("C[0-9]*")){
                reviewRepository.delete(reviewSelected);
                return "RoomReview Deleted";
            }else{
                throw new ReviewException(ReviewError.WRONG_FORMAT);
            }
        }).orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    public String deleteCustomerReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected-> {
            if(reviewSelected.getCommentTo().matches("C[0-9]*") && reviewSelected.getCommentBy().matches("H[0-9]*")){
                reviewRepository.delete(reviewSelected);
                return "CustomerReview Deleted";
            }else{
                throw new ReviewException(ReviewError.WRONG_FORMAT);
            }
        }).orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    public String deleteHostReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected-> {
            if(reviewSelected.getCommentTo().matches("H[0-9]*") && reviewSelected.getCommentBy().matches("C[0-9]*")){
                reviewRepository.delete(reviewSelected);
                return "HostReview Deleted";
            }else{
                throw new ReviewException(ReviewError.WRONG_FORMAT);
            }
        }).orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }
}
