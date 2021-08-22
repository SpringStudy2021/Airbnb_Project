package com.example.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payId;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private Long roomId;

    private Long rsvId;

    private Long price;

    private Long length;

    private Date startDate;

    private Date endDate;


    public void wholePrice(){ //reservation에서 전체 결제금액을 정의하지 않았을 때 payment에서 price를 예약 일수만큼 재정의 하고 저장
        Long diffDays = startDate.getTime() - endDate.getTime();
        this.price = diffDays * price;
        this.length = diffDays;
    }

}
