package com.ecy.orderservice.dto;

import com.ecy.data.enums.InventoryStatus;
import com.ecy.data.enums.OrderStatus;
import com.ecy.data.enums.PaymentStatus;
import lombok.Data;

import java.time.Instant;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:11
 */

@Data
public class OrderResponseDTO {

    private String orderId;
    private String productId;
    private Integer quantity;
    private Instant orderDate;
    private String userId;

    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private InventoryStatus inventoryStatus;

}