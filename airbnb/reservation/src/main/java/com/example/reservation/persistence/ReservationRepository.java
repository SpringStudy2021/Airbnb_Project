package com.example.reservation.persistence;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ReservationRepository extends JpaRepository<Reservation,Long> {


}
