package com.example.room.aggregate;

import com.example.room.model.Room;
import com.example.room.model.RoomCreated;
import com.example.room.model.RoomDeleted;
import com.example.room.model.RoomUpdated;
import com.example.room.processor.MessageProducer;
import com.example.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final MessageProducer messageProducer;

    // RoomCommand 필요 -> room이 dto -> command라고 생각하자
    public Room createRoom(RoomCreated roomCreated) {
        Room room = Room.builder().
//                id(roomCreated.getId()).
                room_name(roomCreated.getRoom_name()).
                address(roomCreated.getAddress()).
                head_count(roomCreated.getHead_count()).
                price(roomCreated.getPrice()).
                img_url(roomCreated.getImg_url()).
                last_action(roomCreated.getLast_action()).
                build();
        return roomRepository.save(room);
    }

    @Transactional
    public Optional<Room> updateRoom(Long Id, RoomUpdated roomUpdated) {
        Optional<Room> room = roomRepository.findById(Id);

        room.ifPresent( roomSelected -> {
                    roomSelected.setRoom_name(roomUpdated.getRoom_name());
                    roomSelected.setAddress(roomUpdated.getAddress());
                    roomSelected.setHead_count(roomUpdated.getHead_count());
                    roomSelected.setPrice(roomUpdated.getPrice());
                    roomSelected.setImg_url(roomUpdated.getImg_url());
                    roomSelected.setLast_action(roomUpdated.getLast_action());

                    roomRepository.save(roomSelected);
                });
        return room;
    }

    @Transactional
    public Optional<Room> deleteRoom(Long id) {
        RoomDeleted roomDeleted = RoomDeleted.builder().id(id).build();
        Optional<Room> room = roomRepository.findById(roomDeleted.getId());
        room.ifPresent( selectRoom -> {
                roomRepository.delete(selectRoom);
                // 리뷰 삭제해주는 이벤트 생성필요
                messageProducer.sendMessage("RoomDeleted", roomDeleted);
        });
        return room;
    }

    public List<Room> getRoomList() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoom(Long id) {
        return roomRepository.findById(id);
    }

}
