package com.example.reservation.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RequestReservation {

    private int roomId;
    private int numOfPeople;

    private String startDate;
//  예약날짜(시작)
    private String endDate;

}
