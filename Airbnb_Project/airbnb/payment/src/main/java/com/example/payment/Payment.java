package com.example.payment;

import com.example.payment.event.PaymentApproved;
import com.example.payment.repository.PaymentRepository;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Data
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payId;

    private Long rsvId;

    private Long roomId;

    private String status;

    //결제요청이 왔을 때
    public Payment PaymentApprove() {
        PaymentApproved paymentApproved = new PaymentApproved("confirmed");
        BeanUtils.copyProperties(this, paymentApproved);
        return this;
    }
}
