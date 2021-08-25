package com.example.room.aggregate;

import com.example.room.model.Room;
import com.example.room.model.RoomCreated;
import com.example.room.model.RoomDeleted;
import com.example.room.model.RoomUpdated;
import com.example.room.processor.MessageProducer;
import com.example.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final MessageProducer messageProducer;

    // RoomCommand 필요 -> room이 dto -> command라고 생각하자
    public void createRoom(RoomCreated roomCreated) {
        Room room = Room.builder().
                id(roomCreated.getId()).
                roomName(roomCreated.getRoomName()).
                address(roomCreated.getAddress()).
                headCount(roomCreated.getHeadCount()).
                price(roomCreated.getPrice()).
                imgUrl(roomCreated.getImgUrl()).
                lastAction(roomCreated.getLastAction()).
                build();
        roomRepository.save(room);
    }

    public void updateRoom(RoomUpdated roomUpdated) {
        Room room = Room.builder().
                id(roomUpdated.getId()).
                roomName(roomUpdated.getRoomName()).
                address(roomUpdated.getAddress()).
                headCount(roomUpdated.getHeadCount()).
                price(roomUpdated.getPrice()).
                imgUrl(roomUpdated.getImgUrl()).
                lastAction(roomUpdated.getLastAction()).
                build();
        roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        RoomDeleted roomDeleted = RoomDeleted.builder().id(id).build();
        Room room = roomRepository.getById(roomDeleted.getId());
        roomRepository.delete(room);
        // 리뷰 삭제해주는 이벤트 생성필요
        messageProducer.sendDeleteMessage(roomDeleted);
    }

    public List<Room> getRoomList() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoom(Long id) {
        return roomRepository.findById(id);
    }

}
