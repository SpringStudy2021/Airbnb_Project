package com.example.reservation.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reservation extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long roomId;

    private Long payId;

    public enum Status{
        RESERVING, RESERVED;
    }

    @Column(nullable = false)
    private Integer numOfPeople;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
// 성능상 Enumerated 어노테이션의 사용은 좋지않음
//  추후에 통합할때  EnumMapperFactory를 사용하여

    private Integer price;

    @Column(nullable = false, updatable = true)
    private LocalDate startDate;
//  예약날짜(시작)

    @Column(nullable = false, updatable = true)
    private LocalDate endDate;
//  예약날짜(종료)

}
