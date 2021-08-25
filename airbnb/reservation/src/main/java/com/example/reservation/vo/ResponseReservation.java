package com.example.reservation.vo;

import com.example.reservation.persistence.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ResponseReservation {

    private Long rvId;

    private Integer roomId;

    private Reservation.Status status;

    private Integer numOfPeople;

    private Integer price;

    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd ", timezone = "Asia/Seoul")
    private LocalDate startDate;
    //  예약날짜(시작)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate endDate;



}
