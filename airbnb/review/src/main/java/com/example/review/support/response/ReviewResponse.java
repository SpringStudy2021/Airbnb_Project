package com.example.review.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewResponse<T> {
    private T data;

    private HttpStatus status;

    private String description;

    private int resultCode;

    // successful일때 data & description만 받아서 만듬
    public ReviewResponse(T data, String description){
        this.data = data;
        this.status = HttpStatus.OK;
        this.resultCode = 200;
        this.description = description;
    }

    // 일반적 response
    public ReviewResponse(T data,HttpStatus status,String description){
        this.data = data;
        this.status = status;
        this.resultCode = status.value();
        this.description = description;
    }

    //data 전달할거 없을 때
    public ReviewResponse(HttpStatus status,String description){
        this.status = status;
        this.resultCode= status.value();;
        this.description = description;
    }


}
