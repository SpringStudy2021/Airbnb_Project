package com.example.room.processor;

import com.example.room.aggregate.RoomService;
import com.example.room.config.kafka.RoomBinder;
import com.example.room.model.RoomDeleted;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private RoomBinder roomBinder;

    public void sendDeleteMessage(RoomDeleted roomDeleted) {
        // TODO: roomDeleted를 json으로 보내야 (삭제된 room에대한 review삭제 처리)
        roomBinder.output().send(MessageBuilder.withPayload("sendTest").build());
    }
}
