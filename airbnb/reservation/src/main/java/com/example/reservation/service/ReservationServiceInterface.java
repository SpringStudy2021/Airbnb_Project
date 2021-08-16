package com.example.reservation.service;

import com.example.reservation.dto.ReservationDto;
import com.example.reservation.vo.ResponseReservation;

public interface ReservationServiceInterface {

    public ResponseReservation reserve(ReservationDto reservationDto);
    public ResponseReservation cancel(Long id);
}
