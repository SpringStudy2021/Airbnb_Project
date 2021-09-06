package com.example.room.processor;

import com.example.room.config.kafka.KafkaConfig;
import com.example.room.model.RoomDeleted;
import com.example.room.util.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private DataFormat dataFormat;

    public RoomDeleted sendMessage(String topic, RoomDeleted roomDeleted) {
        String json = dataFormat.objectToJson(roomDeleted);
        kafkaTemplate.send(topic, json);
        System.out.println("kafka send Message = " + roomDeleted);

        return roomDeleted;
    }
}
