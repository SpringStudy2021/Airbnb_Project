package com.example.reservation.event;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationCreated {
    
    private Long rvId;
    private Integer price;

}
