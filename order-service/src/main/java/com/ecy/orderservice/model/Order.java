package com.ecy.orderservice.model;

import com.ecy.data.enums.InventoryStatus;
import com.ecy.data.enums.OrderStatus;
import com.ecy.data.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:04
 */

@Data
@NoArgsConstructor
@Document(value = "order")
public class Order implements Serializable {

    @Id
    private String orderId;
    private String productId;
    private Integer quantity;
    private Instant orderDate;
    private String userId;

    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private InventoryStatus inventoryStatus;

    @Version
    private int version;

}