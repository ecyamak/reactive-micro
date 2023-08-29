package com.ecy.inventoryservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:13
 */

@Data
@NoArgsConstructor
@Document(value = "inventory")
public class Inventory {

    @Id
    private String productId;
    private Integer stock;

}