package com.example.reservation.vo;

import lombok.Data;

@Data
public class ResponseReservation {

    private int rvId;

    private int roomId;

    private String status;

    private int payId;

    private int numOfPeople;

    private int price;

    private String startDate;
    //  예약날짜(시작)
    private String endDate;


}
