package com.example.reservation.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {


    Optional<Reservation> findByRvId(Long rvId);
}
