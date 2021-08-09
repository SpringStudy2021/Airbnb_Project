package com.example.reservation.service;

import com.example.reservation.persistence.Reservation;
import com.example.reservation.persistence.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationServiceInterface{

    private final ReservationRepository reservationRepository;
//    payment 마이크로서비스에 대한 의존성 추가

    @Override
    @Transactional
    public void reserve(Long rvId) {
//        동기처리를 위한  예약 메소드
        Reservation reservation = new Reservation(1,1,"reserving",1);
        reservationRepository.save(reservation);
//
//       payment = approvePayment(reservation)
//       approvePayment 동기 호출 -> 결제승인 메소드가 정상적으로 호출되고 이벤트를 발행했음을 확인, reservation자체를 주기보다는 tempReservation이런거를 주는게 좋을듯
//       reservationRepository.changeStatus(Payment)
//       payment로 부터 발생된 payment를 전달받고 status를 바꿔준다. (reserving -> reserved)
//       (호출한 뒤 payId를 받아 해당 예약 객체의 payId에 payId를 저장한다.)
//
    }

    @Override
    @Transactional
    public void cancel(Long rvId){
//        매개변수로 전달받은 roomId를 통해 reservation을 찾고
//         해당 reservation에 대한 취소이벤트 발행한다.
    }
}
