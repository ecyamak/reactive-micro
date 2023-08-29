package com.ecy.data.event;

import com.ecy.data.dto.PaymentDTO;
import com.ecy.data.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 23:09
 */

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PaymentEvent extends BaseEvent {

    private PaymentDTO paymentDTO;
    private PaymentStatus paymentStatus;

}