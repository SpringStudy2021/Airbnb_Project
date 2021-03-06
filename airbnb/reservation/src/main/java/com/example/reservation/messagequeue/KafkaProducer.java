package com.example.reservation.messagequeue;


import com.example.reservation.event.ReservationCancelled;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {
    private KafkaTemplate<String ,String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public ReservationCancelled send(String topic, ReservationCancelled reservationCancelled) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try{
            jsonInString = mapper.writeValueAsString(reservationCancelled);

        }catch (JsonProcessingException ex){
            ex.printStackTrace();

        }
        kafkaTemplate.send(topic, jsonInString);
        log.info("Kafka Producer send " + reservationCancelled);

        return reservationCancelled;
    }

}
