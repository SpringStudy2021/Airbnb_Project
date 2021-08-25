package com.example.room.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@Table(name = "room")
public class RoomUpdated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roomName")
    @NotNull
    private String roomName;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "headCount")
    private Integer headCount;

    @Column(name = "price")
    @NotNull
    private Long price;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "lastAction")
    private String lastAction;
}
