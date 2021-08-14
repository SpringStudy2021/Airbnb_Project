package com.example.room.aggregate;

import com.example.room.model.Room;
import com.example.room.model.RoomCreated;
import com.example.room.model.RoomDeleted;
import com.example.room.model.RoomUpdated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    public Room createRoom(RoomCreated roomCreated) {

    }

    public Room updateRoom(RoomUpdated roomUpdated) {

    }

    public boolean deleteRoom(RoomDeleted roomDeleted) {

        // 리뷰 삭제해주는 이벤트 생성필요
    }



}
