package com.example.review.aggregate;

import com.example.review.domain.Review;
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
        String result = checkIds("R",reviewRequest.getCommentBy(),reviewRequest.getCommentTo());
        Review review = Review.of(reviewRequest.getCommentBy(),reviewRequest.getCommentTo(),reviewRequest.getDescription(),reviewRequest.getScore());
        reviewRepository.save(review);
        return result+" Created";
    }

    public String createHostReview(ReviewRequest reviewRequest) {
        String result = checkIds("H",reviewRequest.getCommentBy(),reviewRequest.getCommentTo());
        Review review = Review.of(reviewRequest.getCommentBy(),reviewRequest.getCommentTo(),reviewRequest.getDescription(),reviewRequest.getScore());
        reviewRepository.save(review);
        return result+" Created";
    }

    public String createCustomerReview(ReviewRequest reviewRequest) {
        String result = checkIds("C",reviewRequest.getCommentBy(),reviewRequest.getCommentTo());
        Review review = Review.of(reviewRequest.getCommentBy(),reviewRequest.getCommentTo(),reviewRequest.getDescription(),reviewRequest.getScore());
        reviewRepository.save(review);
        return result+" Created";
    }

    public String deleteRoomReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected->
                checkIds("R",reviewSelected.getCommentBy(),reviewSelected.getCommentTo()) + " Deleted")
                .orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    public String deleteCustomerReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected->
                checkIds("C",reviewSelected.getCommentBy(),reviewSelected.getCommentTo()) + " Deleted")
                .orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    public String deleteHostReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected->
                checkIds("H",reviewSelected.getCommentBy(),reviewSelected.getCommentTo()) + " Deleted")
                .orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    public String updateRoomReview(Long id, ReviewRequest request) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected->{
            reviewSelected.update(request.getDescription(),request.getScore());
            reviewRepository.save(reviewSelected);
            return "RoomReview Updated";
        }).orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    public String updateHostReview(Long id, ReviewRequest request) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected->{
            reviewSelected.update(request.getDescription(),request.getScore());
            reviewRepository.save(reviewSelected);
            return "HostReview Updated";
        }).orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    public String updateCustomerReview(Long id, ReviewRequest request) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(reviewSelected->{
            reviewSelected.update(request.getDescription(),request.getScore());
            reviewRepository.save(reviewSelected);
            return "CustomerReview Updated";
        }).orElseThrow(()->new ReviewException(ReviewError.ENTITY_NOT_FOUND));
    }

    private String checkIds(String reviewType,String commentById,String commentToId){
        switch (reviewType){
            case "R":
                if(commentById.matches("C[0-9]*") && commentToId.matches("R[0-9]*"))    return "RoomReview";
                else throw new ReviewException(ReviewError.WRONG_FORMAT);
            case "H":
                if(commentById.matches("C[0-9]*") && commentToId.matches("H[0-9]*"))    return "HostReview";
                else throw new ReviewException(ReviewError.WRONG_FORMAT);
            default:
                if(commentById.matches("H[0-9]*") && commentToId.matches("C[0-9]*"))    return "CustomerReview";
                else throw new ReviewException(ReviewError.WRONG_FORMAT);
        }
    }
}
