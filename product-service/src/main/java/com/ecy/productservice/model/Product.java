package com.ecy.productservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 20:22
 */

@Data
@Builder
@Document(value = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}