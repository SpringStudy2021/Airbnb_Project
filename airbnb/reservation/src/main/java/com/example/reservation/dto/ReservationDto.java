package com.example.reservation.dto;

import lombok.Data;

@Data
public class ReservationDto {

    private int roomId;

    private String status;

    private int numOfPeople;

    private int price;

    private String startDate;
    //  예약날짜(시작)
    private String endDate;

    public ReservationDto(int roomId,int numOfPeople, int price, String startDate, String endDate){

        this.roomId = roomId;
        this.status = "reserving";
        this.numOfPeople = numOfPeople;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
