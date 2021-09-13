package com.example.review.support.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ReviewError {
    ENTITY_NOT_FOUND("Cannot find review entity", HttpStatus.NOT_FOUND),
    DUPLICATE("Duplicate input",HttpStatus.BAD_REQUEST),
    WRONG_FORMAT("Wrong input",HttpStatus.BAD_REQUEST),
    NOT_PERMITTED("Create review not allowed",HttpStatus.FORBIDDEN);

    private String description;
    private HttpStatus status;

    ReviewError(String description,HttpStatus status){
        this.description = description;
        this.status = status;
    }
}
