package com.example.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private Long payId;

    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private Long rsvID;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Long lengthOfStay;

    private Date startDate;

    private Date endDate;

    public void wholePrice(){ //reservation에서 전체 결제금액을
        //정의하지 않았을 때 payment에서 price를 예약 일수만큼 재정의 하고 저장
        Long diffDays = startDate.getTime() - endDate.getTime();
        this.price = diffDays * price;
        this.lengthOfStay = diffDays;
    }

}
