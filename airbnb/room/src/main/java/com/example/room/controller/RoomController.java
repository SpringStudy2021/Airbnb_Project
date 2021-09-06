package com.example.room.controller;

import com.example.room.aggregate.RoomService;
import com.example.room.model.Room;
import com.example.room.model.RoomCreated;
import com.example.room.model.RoomUpdated;
import com.example.room.response.CommonResponse;
import com.example.room.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    public ResponseEntity getRoomList() {
//        return ResponseEntity.ok().body(roomService.getRoomList());
        List<Room> roomList = roomService.getRoomList();
        if (roomList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("NOT FOUND"));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CommonResponse<List<Room>>(roomList, "Room List"));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateRoom(@RequestBody RoomUpdated roomUpdated, @PathVariable("id") Long id) {
        Optional<Room> room = roomService.updateRoom(id, roomUpdated);
//        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.UPDATE_ROOM), HttpStatus.OK);
        if (room.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CommonResponse<Optional<Room>>(room, "Updated Room"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("NOT FOUND"));
        }
    }

    @PostMapping("/")
    public ResponseEntity createRoom(@RequestBody RoomCreated roomCreated) {
        Room room = roomService.createRoom(roomCreated);
//        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.ROOM_CREATE_SUCCESS, roomCreated), HttpStatus.OK);
        if (room == null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CommonResponse<Room>(room, "Created Room"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("NOT FOUND"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoom(@PathVariable("id") Long id) {
//        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.READ_ROOM, roomService.getRoom(id)), HttpStatus.OK);
        Optional<Room> room = roomService.getRoom(id);
        if (room.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CommonResponse<Optional<Room>>(room, "Room Info"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("NOT FOUND"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable("id") Long id) {
        Optional<Room> room = roomService.deleteRoom(id);
//        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.DELETE_ROOM), HttpStatus.OK);
        if (room.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CommonResponse<Optional<Room>>(room, "Deleted Room"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("NOT FOUND"));
        }
    }
}
