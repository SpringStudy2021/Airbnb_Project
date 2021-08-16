package com.example.event;

public class PaymentApproved extends AbstractEvent{

    private Long payId;
    private Long roomId;
    private Long rsvID;
    private Long price;
    private String status;

    public PaymentApproved(){
        this.status = "payment confirmed";
    }
}
