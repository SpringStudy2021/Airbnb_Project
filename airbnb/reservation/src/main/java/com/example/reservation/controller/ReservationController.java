package com.example.reservation.controller;

import com.example.reservation.dto.ReservationDto;
import com.example.reservation.service.ReservationServiceInterface;
import com.example.reservation.vo.RequestReservation;
import com.example.reservation.vo.ResponseReservation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation-service")
public class ReservationController {

//    컨트롤러는 외부에서 에약 서비스로 접근하는 모든 API에 대해 핸들링한다.
//    policy Handle와 다른 느낌
    ReservationServiceInterface  reservationServiceInterface;

    @Autowired
    public ReservationController(ReservationServiceInterface reservationServiceInterface) {
        this.reservationServiceInterface = reservationServiceInterface;
    }

    @PostMapping("/reserve")
    public ResponseEntity<ResponseReservation> reserve(@RequestBody RequestReservation requestReservation){

        ReservationDto reservationDto = new ModelMapper().map(requestReservation,ReservationDto.class);
//        지금은 Dto에 setter로 reserving 상태로 넣어주는데,
//        생성자를 통해 자동 reserving되는걸로 추후에 수정하기
        reservationDto.setStatus("reserving");
        ResponseReservation responseReservation = reservationServiceInterface.reserve(reservationDto);

        return new ResponseEntity(responseReservation, HttpStatus.CREATED);

    }

//    @PostMapping("/cancel/{id}")
//    public void cancel(@PathVariable("id") Long rvId){
//
//        reservationServiceInterface.cancel(rvId);
//    }

//    현재 방예약상태를 보여주는 api제공해줘야 되지않나?
//    날짜와 방번호를 받아서 해당 예약에대한 status를 확인
//    레코드자체가 없거나 status가 non-reserved이면 예약되어있지 않음으로 반환?

//    방이 생성되면 해당 날짜에 대한 예약도 생성이 되는건가?


}
