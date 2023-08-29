package com.ecy.inventoryservice.dto;

import lombok.Data;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:13
 */

@Data
public class InventoryResponseDTO {

    public String productId;
    public Integer stock;

}