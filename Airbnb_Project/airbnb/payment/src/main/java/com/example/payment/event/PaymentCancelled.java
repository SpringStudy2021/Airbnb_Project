package com.example.payment.event;

import lombok.Data;

@Data
public class PaymentCancelled extends AbstractEvent{

    private Long payId;

    private Long rsvId;

    private Long roomId;

    private String status;
}
