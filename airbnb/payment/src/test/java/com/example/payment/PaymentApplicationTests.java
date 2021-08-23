package com.example.payment;

import com.example.event.PaymentApproved;
import com.example.repository.Payment;
import com.example.repository.PaymentRepository;
import com.example.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.IOException;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PaymentApplicationTests {

    Payment payment;
    PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    void contextLoads() {
        Payment payment = new Payment();
        PaymentApproved paymentApproved = new PaymentApproved();
        BeanUtils.copyProperties(paymentApproved, payment);
        System.out.println(paymentApproved.toString());
        System.out.println(paymentService.paymentApproved().toString());
    }
        //    }
//    @Test
//    void controller() throws IOException {
//        this.paymentService = new PaymentService();
//        this.payment = paymentService.paymentApproved();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File("payment.json"), payment);
//        System.out.println(payment.toString());
//    }

    @Test
    void save(){
        Payment payment = new Payment();
        paymentRepository.save(payment);
        paymentRepository.findAll().forEach(System.out::println);
    }
}
