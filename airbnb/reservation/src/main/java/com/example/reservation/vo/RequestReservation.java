package com.example.reservation.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RequestReservation {

    private Integer roomId;

    private Integer numOfPeople;

    private Integer price;

    private String startDate;
//  예약날짜(시작)
    private String endDate;

}
