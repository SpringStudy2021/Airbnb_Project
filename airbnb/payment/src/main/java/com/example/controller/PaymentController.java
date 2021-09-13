
package com.example.controller;

import com.example.repository.Payment;
import com.example.repository.PaymentRepository;
import com.example.service.PaymentService;
import com.example.vo.RequestPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/payment-service")
@Slf4j
public class PaymentController {

    PaymentRepository paymentRepository;
    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository , PaymentService paymentService) {
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
    }

    @PostMapping("/approvePayment")
    public Long approvePayment(@RequestBody RequestPayment requestPayment){
        log.info("controller approvePayment called");
        return paymentService.approvePayment(requestPayment);
    }

    @GetMapping("/message")
    public void LogInfo(){
        log.info("access complete");
    }

//    @GetMapping("/approved")
//    public void PaymentRequest() throws IOException {
//        paymentService = new PaymentService();
//        ObjectMapper objectMapper = new ObjectMapper();
//        Payment payment = paymentService.paymentApproved();
//        paymentRepository.save(payment);
//        System.out.println(payment);
//        objectMapper.writeValue(new File("payment.json"), payment);
//    }
//
//    @GetMapping("/cancelled/{payId}")
//    public void PaymentCancelled(@PathVariable Long payId){
//        Payment cancelRequest = paymentRepository.findPaymentByPayId(payId);
//        //cancelRequest를 reservation에 바로 전달
//        paymentRepository.deleteById(payId);
//    }

}