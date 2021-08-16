package com.example.reservation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationDto {

//    private String rvId;

    private Integer roomId;

    private String status;

    private Integer numOfPeople;

    private Integer price;

    private String startDate;
    //  예약날짜(시작)
    private String endDate;


}
