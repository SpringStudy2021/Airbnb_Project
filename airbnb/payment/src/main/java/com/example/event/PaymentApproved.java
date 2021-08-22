package com.example.event;


import com.example.repository.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentApproved extends AbstractEvent{


    private Long id;

    private Long payId;

    private Status status;

    private Long roomId;

    private Long rsvId;

    private Long price;

    private Long length;

    private Date startDate;

    private Date endDate;


}
