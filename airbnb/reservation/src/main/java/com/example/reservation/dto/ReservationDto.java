package com.example.reservation.dto;

import com.example.reservation.persistence.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReservationDto {

//    private String rvId;

    private Long roomId;

    private Reservation.Status status;

    private Integer numOfPeople;

    private Integer price;

    private LocalDate startDate;
    //  예약날짜(시작)
    private LocalDate endDate;


}
