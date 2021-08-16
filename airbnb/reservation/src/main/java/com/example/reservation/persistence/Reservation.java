package com.example.reservation.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer roomId;

    private Integer payId;

    @Column(nullable = false)
    private String status;

    private Integer price;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;
    //    예약생성시간(자동설정초기화)

    @Column(nullable = false, updatable = false)
    private String startDate;
//  예약날짜(시작)

    @Column(nullable = false, updatable = false)
    private String endDate;
//  예약날짜(종료)



}
