package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
//    void delete(Optional<Payment> byId);
}
