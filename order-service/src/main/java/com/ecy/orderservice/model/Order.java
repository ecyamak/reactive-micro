package com.ecy.orderservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:04
 */

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@Document(value = "order")
public class Order implements Serializable {

    @Id
    private String id;
    private String item;

}