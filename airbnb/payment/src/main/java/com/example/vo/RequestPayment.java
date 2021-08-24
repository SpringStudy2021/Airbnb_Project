package com.example.vo;


import lombok.Data;

@Data
public class RequestPayment {

//    추후에 id 다 rvId로 바꿀 예정
    private Long rvId;
    private Long price;
}
