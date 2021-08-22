package com.example.reservation.service;

import com.example.reservation.dto.ReservationDto;
import com.example.reservation.event.ReservationCancelled;
import com.example.reservation.event.ReservationCreated;
import com.example.reservation.messagequeue.KafkaProducer;
import com.example.reservation.persistence.Reservation;
import com.example.reservation.persistence.ReservationRepository;
import com.example.reservation.vo.ResponseReservation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class ReservationServiceImpl implements ReservationServiceInterface {


    private final ReservationRepository reservationRepository;
    private final KafkaProducer kafkaProducer;
    //    payment 마이크로서비스에 대한 의존성 추가


    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository , KafkaProducer kafkaProducer) {
        this.reservationRepository = reservationRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    @Transactional
    public ResponseReservation reserve(ReservationDto reservationDto) {

        ReservationCreated reservationCreated = new ModelMapper().map(reservationDto,ReservationCreated.class);

        //        reservationCreated 이벤트를 발행하여 해당 이벤트를 통해 동기호출을 한다.
        //        동기호출을 통해 정상적으로 결제승인메소드가 호출되었음을 응답 받으면 아래 코드들 실행

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Reservation reservation = mapper.map(reservationDto,Reservation.class);

        reservationRepository.save(reservation);
        log.debug(reservation.toString());
        ResponseReservation responseReservation = new ModelMapper().map(reservation,ResponseReservation.class);

        return  responseReservation;

//       Reservation의 payId는 paymentApproved 이벤트가 발생했을때
//       reservation이 받고 그 이벤트 내에 있는 payid를 rvId를 통해 찾은 예약 레코드에 저장한다.

    }

    @Override
    @Transactional
    public ResponseReservation cancel(Long id){

        Optional<Reservation> reservationOptional = reservationRepository.findById(id);

        if (reservationOptional.isPresent()){
            Reservation reservation = reservationOptional.get();
            ReservationCancelled reservationCancelled = new ModelMapper().map(reservation, ReservationCancelled.class);

//          발행한 예약취소이벤트를 kafkaProducer가 메세지 큐에 보낸다.
            kafkaProducer.send("ReservationCancelled", reservationCancelled);
            log.info("Kafka Producer send to topics(ReservationCancelled)" + reservationCancelled );

            ResponseReservation responseReservation = new ModelMapper().map(reservation,ResponseReservation.class);

            return  responseReservation;
        }

        return null;
    }
}
