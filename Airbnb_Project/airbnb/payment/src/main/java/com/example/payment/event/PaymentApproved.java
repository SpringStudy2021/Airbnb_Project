package com.example.payment.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentApproved extends AbstractEvent{

    public PaymentApproved(String status){
        status = this.status;
    }

    private Long payId;

    private Long rsvId;

    private Long roomId;

    private String status;
}
