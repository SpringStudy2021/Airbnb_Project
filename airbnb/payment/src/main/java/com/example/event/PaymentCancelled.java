package com.example.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCancelled extends AbstractEvent{

    private Long id;

    private Long payId;

    private String status;

    private Long roomId;

    private Long rsvId;

    private Long price;

    private Long length;

    private Date startDate;

    private Date endDate;


}
