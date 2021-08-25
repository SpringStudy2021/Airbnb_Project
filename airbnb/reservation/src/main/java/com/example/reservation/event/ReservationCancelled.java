package com.example.reservation.event;

import lombok.Data;

@Data
public class ReservationCancelled {
    private Long rvId;
    private Long payId;
    private Integer price;

}
