package com.ecy.paymentservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:00
 */

@Data
@NoArgsConstructor
@Document(value = "payment")
public class Payment {

    @Id
    private String orderId;
    private String userId;
    private Integer amount;

}