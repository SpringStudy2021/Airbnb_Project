package com.example.reservation.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseReservation {

    private Long id;

    private Integer roomId;

    private String status;

    private Integer numOfPeople;

    private Integer price;

    private Date createdDate;

    private String startDate;
    //  예약날짜(시작)
    private String endDate;



}
