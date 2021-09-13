package com.example.room.repository;

import com.example.room.model.Room;
import com.example.room.model.RoomCreated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
