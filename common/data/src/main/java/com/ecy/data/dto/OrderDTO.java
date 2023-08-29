package com.ecy.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 23:06
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements BaseDTO {

    private String orderId;
    private String productId;
    private Integer amount;
    private String userId;

}