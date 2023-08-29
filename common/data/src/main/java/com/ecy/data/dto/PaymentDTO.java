package com.ecy.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 23:11
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO implements BaseDTO {

    private String orderId;
    private String userId;
    private Integer amount;

}