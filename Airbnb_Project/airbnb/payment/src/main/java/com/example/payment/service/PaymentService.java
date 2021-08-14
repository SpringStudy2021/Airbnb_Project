package com.example.payment.service;

import com.example.payment.event.PaymentApproved;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public void PaymentSuccess(){

    }

}

