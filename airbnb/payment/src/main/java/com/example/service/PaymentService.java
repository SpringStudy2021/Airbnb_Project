package com.example.service;

import com.example.event.PaymentApproved;
import com.example.event.PaymentCancelled;
import com.example.messagequeue.KafkaProducer;
import com.example.repository.Payment;
import com.example.repository.PaymentRepository;
import com.example.vo.RequestPayment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class PaymentService {

    PaymentRepository paymentRepository;
    KafkaProducer kafkaProducer;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, KafkaProducer kafkaProducer) {
        this.paymentRepository = paymentRepository;
        this.kafkaProducer = kafkaProducer;
    }
//
//    @Transactional
//    public Payment paymentApproved(){
//        payment = new Payment();
//        PaymentApproved paymentApproved = new PaymentApproved();
//        BeanUtils.copyProperties(paymentApproved, payment);
//        //payment.wholePrice();
//        payment.setStatus(Status.PAYMENT_CONFIRMED);
//        return payment;
//    }
    //결제 실행되었을 때 -> status가 'payment confirm'인 PaymentApproved 객체가 생성되고 Payment에 해당 변수들을 저장하고 DB에 저장. payId는 1씩 증가하도록
    //reservation의 startDate와 endDate의 차이와 Reservation의 price를 곱하여 Payment의 price결정
    //paymentApproved가 reservation에서 넘어온 정보를 포함하고 있어야함.
    //마지막에 결제가 완료되면 payId를 reservation에 전달해서 reservation에서 취소를 요청할 때 해당 방의 payId를 전달해
    //바로 paymentCancelled의 payId에 매핑해서 메서드를 실행할 수 있을까?


    @Transactional
    public Long approvePayment(RequestPayment requestPayment){

        Payment payment = new ObjectMapper().convertValue(requestPayment, Payment.class);
        Payment resultPayment = paymentRepository.save(payment);
        PaymentApproved paymentApproved= new ObjectMapper()
                .convertValue(payment, PaymentApproved.class);

        kafkaProducer.send("PaymentApproved",paymentApproved);
        return resultPayment.getPayId();
    }

    //결제 취소되었을 때 -> status가 'payment cancelled'인 PaymentCancelled 객체가 생성되고 입력된 payId가 있는 row를 DB에서 삭제.
    @Transactional
    public void cancelPayment(Long payId){ //입력하는 payId에 대하여 상태를 "결제 취소됨"으로 변경

        Optional<Payment> paymentOptional = paymentRepository.findPaymentByPayId(payId);

        if (paymentOptional.isPresent()) {
            paymentRepository.delete(paymentOptional.get());
            PaymentCancelled paymentCancelled = new ObjectMapper()
                    .convertValue(paymentOptional.get(), PaymentCancelled.class);

            kafkaProducer.send("PaymentCancelled",paymentCancelled);
            log.info("kafka Producer send paymentCancelled event" + paymentCancelled);
        }
        else{
            log.info("rvId:"+ payId + "payment does not exists");
        }

        //cancelRequest를 reservation에 바로 전달
    }
}