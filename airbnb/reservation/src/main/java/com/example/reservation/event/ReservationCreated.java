package com.example.reservation.event;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationCreated {
    private int rvId;
    private int price;

}
