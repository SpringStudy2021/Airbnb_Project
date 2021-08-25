package com.example.room.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Room {
    // dto

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
