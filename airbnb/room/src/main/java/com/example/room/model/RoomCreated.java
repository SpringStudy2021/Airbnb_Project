package com.example.room.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Builder
@Table(name = "room")
public class RoomCreated {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "room_name")
    @NotNull
    private String room_name;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "head_count")
    private Integer head_count;

    @Column(name = "price")
    @NotNull
    private Long price;

    @Column(name = "img_url")
    private String img_url;

    @Column(name = "last_action")
    private String last_action;
}
