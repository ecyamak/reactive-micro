package com.ecy.paymentservice.dto;

import lombok.Data;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:04
 */

@Data
public class PaymentResponseDTO {

    private String orderId;
    private String userId;
    private Integer amount;

}