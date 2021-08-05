package com.example.room.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "headCount")
    private Integer headCount;

    @Column(name = "price")
    private Long price;

    @Column(name = "imgUrl")
    private String imgUrl;

    private String lastAction;
}
