package com.example.reservation.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int rvId;

    private int roomId;

    private String status;

    private int payId;

//    public Reservation(int rvId, int roomId,String status, int payId){
//        this.rvId = rvId;
//        this.roomId = roomId;
//        this.status = status;
//        this.payId = payId;
//    }
}
