package com.example.room.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends BasicResponse {
    private String result_code;
    private String status;
    private String description;

    public ErrorResponse(String result_code, String status, String description) {
        this.result_code = result_code;
        this.status = status;
        this.description = description;
    }

    public ErrorResponse(String description) {
        this.result_code = "404";
        this.status = "NOT FOUND";
        this.description = description;
    }
}
