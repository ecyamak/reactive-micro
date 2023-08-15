package com.ecy.productservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 20:40
 */

@Data
@Builder
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}