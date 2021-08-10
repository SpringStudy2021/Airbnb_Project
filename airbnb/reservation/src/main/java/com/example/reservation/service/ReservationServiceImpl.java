package com.example.reservation.service;

import com.example.reservation.dto.ReservationDto;
import com.example.reservation.event.ReservationCreated;
import com.example.reservation.persistence.Reservation;
import com.example.reservation.persistence.ReservationRepository;
import com.example.reservation.vo.ResponseReservation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.regex.Matcher;

@Service
public class ReservationServiceImpl implements ReservationServiceInterface {


    private final ReservationRepository reservationRepository;
//    payment 마이크로서비스에 대한 의존성 추가


    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    @Transactional
    public ResponseReservation reserve(ReservationDto reservationDto) {

        ReservationCreated reservationCreated = new ModelMapper().map(reservationDto,ReservationCreated.class);
//        reservationCreated 이벤트를 발행하여 해당 이벤트를 통해 동기호출을 한다.
        //        reservation Dto 에 rvId와 생성날짜(자동) 상태를 초기화해준다.
//        동기호출을 통해 정상적으로 결제승인메소드를 받으면 (TRUE) 저장하기 PAYID아직 모르는 상태
        Reservation reservation = new ModelMapper().map(reservationDto,Reservation.class);
        reservationRepository.save(reservation);

        ResponseReservation responseReservation = new ModelMapper().map(reservation,ResponseReservation.class);
        return  responseReservation;




//       Reservation의 payId는 paymentApproved 이벤트가 발생했을때 reservation이
//       이 이벤트를 받고 거기에있는 payid를 rvId를 통해 찾은 reservation에 저장한다.
//
    }

    @Override
    @Transactional
    public ResponseReservation cancel(ReservationDto reservationDto){
//        매개변수로 전달받은 roomId를 통해 reservation을 찾고
//         해당 reservation에 대한 취소이벤트 발행한다.
        return null;
    }
}
