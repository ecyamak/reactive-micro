package com.ecy.productservice.util;

import com.ecy.productservice.dto.ProductRequest;
import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.model.Product;
import com.ecy.productservice.record.SearchCriteria;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Author: ecyamak
 * Date: 16.10.2023
 * Time: 11:21
 */

public class ProductMockUtil {

    private ProductMockUtil() {}

    public static Product mockProduct() {
        var product = new Product();
        product.setName("Product#1");
        product.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        product.setPrice(BigDecimal.valueOf(10));
        return product;
    }

    public static ProductRequest mockProductRequest() {
        var product = mockProduct();
        return ProductRequest.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static ProductResponse mockProductResponse() {
        var product = mockProduct();
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static SearchCriteria mockSearchCriteria() {
        return SearchCriteria.of(Optional.of("name"),
                Optional.of("Product#1"),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty());
    }

}
