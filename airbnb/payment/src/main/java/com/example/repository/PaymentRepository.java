package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {


    @Override
    <S extends Payment> S save(S entity);

    Optional<Payment> findPaymentByPayId(Long payId);
    Optional<Payment> findPaymentByRvId(Long rvId);
}
