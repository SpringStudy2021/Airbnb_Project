package com.example.reservation.dto;

import com.example.reservation.persistence.Reservation;
import com.example.reservation.persistence.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReservationDto {


    private Long roomId;

    private Status status;

    private Integer numOfPeople;

    private Integer price;

    private LocalDate startDate;
    //  예약날짜(시작)
    private LocalDate endDate;


}
