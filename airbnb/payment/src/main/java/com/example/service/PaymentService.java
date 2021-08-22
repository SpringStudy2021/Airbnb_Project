package com.example.service;

import com.example.event.PaymentApproved;
import com.example.repository.Payment;
import com.example.repository.PaymentRepository;
import com.example.repository.Status;
import org.springframework.beans.BeanUtils;

import javax.transaction.Transactional;

public class PaymentService {


    Payment payment;

    @Transactional
    public Payment paymentApproved(){
        payment = new Payment();
        PaymentApproved paymentApproved = new PaymentApproved();
        BeanUtils.copyProperties(paymentApproved, payment);
        //payment.wholePrice();
        payment.setStatus(Status.PAYMENT_CONFIRMED);
        return payment;
    }
        //결제 실행되었을 때 -> status가 'payment confirm'인 PaymentApproved 객체가 생성되고 Payment에 해당 변수들을 저장하고 DB에 저장. payId는 1씩 증가하도록
        //reservation의 startDate와 endDate의 차이와 Reservation의 price를 곱하여 Payment의 price결정
        //paymentApproved가 reservation에서 넘어온 정보를 포함하고 있어야함.
        //마지막에 결제가 완료되면 payId를 reservation에 전달해서 reservation에서 취소를 요청할 때 해당 방의 payId를 전달해
        //바로 paymentCancelled의 payId에 매핑해서 메서드를 실행할 수 있을까?


    //결제 취소되었을 때 -> status가 'payment cancelled'인 PaymentCancelled 객체가 생성되고 입력된 payId가 있는 row를 DB에서 삭제.
//    public void paymentCancelled(Long payId){ //입력하는 payId에 대하여 상태를 "결제 취소됨"으로 변경
//        Payment cancelRequest = paymentRepository.findPaymentById(payId);
//        //cancelRequest를 reservation에 바로 전달
//    }
}
