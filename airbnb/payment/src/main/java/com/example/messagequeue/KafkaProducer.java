package com.example.messagequeue;


import com.example.event.AbstractPaymentEvent;

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


    public AbstractPaymentEvent send(String topic, AbstractPaymentEvent abstractPaymentEvent) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try{
            jsonInString = mapper.writeValueAsString(abstractPaymentEvent);

        }catch (JsonProcessingException ex){
            ex.printStackTrace();

        }
        kafkaTemplate.send(topic, jsonInString);
        log.info("Kafka Producer send " + abstractPaymentEvent);

        return abstractPaymentEvent;
    }

}
