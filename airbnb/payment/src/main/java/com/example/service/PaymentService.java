package com.example.service;

import com.example.event.PaymentApproved;
import com.example.repository.Payment;
import com.example.repository.PaymentRepository;
import org.springframework.beans.BeanUtils;

public class PaymentService {

    PaymentRepository paymentRepository;

    public void paymentApproved(){
        Payment payment = new Payment();
        //결제 실행되었을 때 -> status가 'payment confirm'인 PaymentApproved 객체가 생성되고 Payment에 해당 변수들을 저장하고 DB에 저장. payId는 1씩 증가하도록
        //reservation의 startDate와 endDate의 차이와 Reservation의 price를 곱하여 Payment의 price결정
        PaymentApproved paymentApproved = new PaymentApproved();
        BeanUtils.copyProperties(payment, paymentApproved);
        payment.wholePrice();
        //payment에 reservation의 속성들 중 이름이 일치하는 것들을 payment의 변수로 저장할 방법고안
        paymentRepository.save(payment);
        System.out.println(payment.toString());
    }

    //결제 취소되었을 때 -> status가 'payment cancelled'인 PaymentCancelled 객체가 생성되고 입력된 payId가 있는 row를 DB에서 삭제.
//    public void paymentCancelled(Long id){ //입력하는 ID에 대한 delete진행
//        paymentRepository.delete(paymentRepository.findById(id));
//        //delete를 하면 남은 row들에 대해서 id를 1씩 빼서 항상 id가 1로 시작하게 하고 싶음
//    }
}
