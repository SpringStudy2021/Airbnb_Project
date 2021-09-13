package com.example.reservation.external;


import com.example.reservation.event.ReservationCreated;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//payment-service 서버의 ip주소를 url에 넣어준다.
//추우 유레카에 등록하면 name만 있으면 된다.
@FeignClient(name = "payment-service" , url = "localhost:9000/payment-service")
public interface PaymentApiClient {

    @RequestMapping(method = RequestMethod.POST, value = "/approvePayment", produces = "application/json")
    Long approvePayment(@RequestBody ReservationCreated reservationCreated);

}
