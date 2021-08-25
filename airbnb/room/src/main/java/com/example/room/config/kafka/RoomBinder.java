package com.example.room.config.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

public interface RoomBinder {
    String INPUT = "room-event-in";
    String OUTPUT = "room-event-out";

    // binder에 연결할 binding설정(input = room-event-in)
    @Input(INPUT)
    SubscribableChannel input();

    // binder에 연결할 binding설정(output = room-event-out)
    @Output(OUTPUT)
    MessageChannel output();

}
