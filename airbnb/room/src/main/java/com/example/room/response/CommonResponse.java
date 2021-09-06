package com.example.room.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse<T> extends BasicResponse {
    private String result_code;
    private String status;
    private String description;
    private T data;

    public CommonResponse(T data, String description) {
        this.result_code = "200";
        this.status = "OK";
        this.description = description;
        this.data = data;
    }

    public CommonResponse(String result_code, String status, String description, T data) {
        this.result_code = result_code;
        this.status = status;
        this.description = description;
        this.data = data;
    }
}
