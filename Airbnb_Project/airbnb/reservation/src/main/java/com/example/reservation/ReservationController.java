package com.example.reservation;

import com.example.reservation.persistence.ReservationRepository;
import com.example.reservation.service.ReservationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

//    컨트롤러는 외부에서 에약 서비스로 접근하는 모든 API에 대해 핸들링한다.
//    policy Handle와 다른 느낌
    ReservationServiceInterface reservationServiceInterface;

    @PostMapping("/reserve/{id}")
    public void reserve(@PathVariable("id") Long rvId){
        reservationServiceInterface.reserve(rvId);
    }

    @PostMapping("/cancel/{id}")
    public void cancel(@PathVariable("id") Long rvId){
        reservationServiceInterface.cancel(rvId);
    }

//    현재 방예약상태를 보여주는 api제공해줘야 되지않나?
//    날짜와 방번호를 받아서 해당 예약에대한 status를 확인
//    레코드자체가 없거나 status가 non-reserved이면 예약되어있지 않음으로 반환?

//    방이 생성되면 해당 날짜에 대한 예약도 생성이 되는건가?


}
