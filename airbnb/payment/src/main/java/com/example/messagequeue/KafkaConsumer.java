package com.example.messagequeue;


import com.example.repository.Payment;
import com.example.repository.PaymentRepository;

import com.example.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@ComponentScan(basePackages={"com.example.service.PaymentService"})
public class KafkaConsumer {


    PaymentService paymentService;

    @Autowired
    public KafkaConsumer(PaymentService service) {
        this.paymentService = service;
    }

    @KafkaListener(topics = "ReservationCancelled") //producer가 ReservationCancelled topic에 데이터를 전송했을 때
    public void cancelPayment(String kafkaMessage) {
        log.info("consumer received event from topics(ReservationCancelled) : "+ kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {
            }); //readValue를 통해 어떤 데이터가 전달됐는지를 확인함

        }catch (JsonProcessingException ex ){
            ex.printStackTrace();
        }

        Long payId =  ((Number) map.get("payId")).longValue();
        paymentService.cancelPayment(payId);
    }




}
