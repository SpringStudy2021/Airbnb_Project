package com.example.messagequeue;


import com.example.reservation.persistence.Reservation;
import com.example.reservation.persistence.ReservationRepository;
import com.example.reservation.persistence.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class KafkaConsumer {

    ReservationRepository repository;

    @Autowired
    public KafkaConsumer(ReservationRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "PaymentApproved")
    public void confirmReserve(String kafkaMessage) {
        log.info("consumer received event from topics(PaymentApproved) : "+ kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {
            });

        }catch (JsonProcessingException ex ){
            ex.printStackTrace();
        }

        Optional<Reservation> reservationOptional = repository.findById( (Long) map.get("rvId") );
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            reservation.setStatus(Status.RESERVED);
            repository.save(reservation);
        }
        else{
            log.info("rvId:"+ (Long)map.get("rvId") + "does not exists");
        }


    }


    @KafkaListener(topics = "PaymentCancelled")
    public void confirmCancel(String kafkaMessage){
        
//        굳이 토픽을 두개만들지말고 PaymentApproved이벤트인지 Cancel이벤트인지 구별해주는 변수값 추가하여
//        하나의 리스너에서 조건문을 통해 로직을 구현할것인가?
//        아니면 지금처럼 리스너 두개를 만들어서 로직을 구현할 것 인가?
        log.info("consumer received event from topics(PaymentCancelled) : "+ kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {
            });

        }catch (JsonProcessingException ex ){
            ex.printStackTrace();
        }
        Optional<Reservation> reservationOptional = repository.findById( (Long) map.get("rvId") );
        if (reservationOptional.isPresent()) {
            repository.delete(reservationOptional.get());
        }
        else{
            log.info("rvId:"+ (Long)map.get("rvId") + "does not exists");
        }
        
        
    }
}
