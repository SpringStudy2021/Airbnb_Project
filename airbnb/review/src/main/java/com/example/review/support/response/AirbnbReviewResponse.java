package com.example.review.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirbnbReviewResponse<T> {

    private T data;

    private HttpStatus status;

    private String description;

    private int resultCode;

    public AirbnbReviewResponse(){}

    // successful일때 data & description만 받아서 만듬
    public AirbnbReviewResponse(T data, String description){
        this.data = data;
        this.status = HttpStatus.OK;
        this.resultCode = 200;
        this.description = description;
    }

    // successful 일때 -> description만 받아서!
    public AirbnbReviewResponse(String description){
        this.status = HttpStatus.OK;
        this.resultCode = status.value();
        this.description = description;
    }

    // 일반적 response
    public AirbnbReviewResponse(T data, HttpStatus status, String description){
        this.data = data;
        this.status = status;
        this.resultCode = status.value();
        this.description = description;
    }

    //data 전달할거 없을 때
    public AirbnbReviewResponse(HttpStatus status, String description){
        this.status = status;
        this.resultCode= status.value();;
        this.description = description;
    }


}
