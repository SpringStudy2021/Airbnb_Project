package com.example.event;

public class PaymentCancelled extends AbstractEvent{

    private Long payId;
    private Long roomId;
    private Long rsvID;
    private Long price;
    private String status;

    public PaymentCancelled(){
        this.status = "결제 안됨";
    }
}
