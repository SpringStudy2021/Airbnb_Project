package com.example.reservation.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int rvId;
//    이거 UUID로 부여할 수 있게끔 할 수 없나 자동으로?

    @Column(nullable = false)
    private int roomId;

    private enum Status {
        RESERVING, RESERVED;
    }

    private int payId;
// 없어도 될듯?!

    @Column(nullable = false)
    private int price;

//    @ColumnDefault()
    private Date createdDate;
//    예약생성시간(자동설정초기화)
    @Column(nullable = false)
    private String startDate;
//  예약날짜(시작)
    @Column(nullable = false)
    private String endDate;
//  예약날짜(종료)


//    public Reservation(int rvId, int roomId,String status, int payId){
//        this.rvId = rvId;
//        this.roomId = roomId;
//        this.status = status;
//        this.payId = payId;
//    }
}
