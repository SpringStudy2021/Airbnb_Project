package com.example.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentApproved extends AbstractPaymentEvent {

    private Long payId;

    private Long rvId;

    private Long price;

}