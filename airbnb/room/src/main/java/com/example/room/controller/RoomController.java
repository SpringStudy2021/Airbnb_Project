package com.example.room.controller;

import com.example.room.aggregate.RoomService;
import com.example.room.model.Room;
import com.example.room.model.RoomCreated;
import com.example.room.model.RoomDeleted;
import com.example.room.model.RoomUpdated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    public ResponseEntity getRoomList() {
        return ResponseEntity.ok().body(roomService.getRoomList());
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateRoom(@RequestBody RoomUpdated roomUpdated, @PathVariable("id") Long id) {
        roomService.updateRoom(roomUpdated);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/")
    public ResponseEntity createRoom(@RequestBody RoomCreated roomCreated) {
        roomService.createRoom(roomCreated);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoom(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(roomService.getRoom(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().body(null);
    }
}
