package com.example.room.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Table(name = "room")
public class RoomDeleted {

    @Id
    @Column(name = "id")
    private Long id;

}
