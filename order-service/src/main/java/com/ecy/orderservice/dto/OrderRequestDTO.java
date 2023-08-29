package com.ecy.orderservice.dto;

import lombok.Data;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:11
 */

@Data
public class OrderRequestDTO {

    private String productId;
    private Integer quantity;
    private String userId;

}