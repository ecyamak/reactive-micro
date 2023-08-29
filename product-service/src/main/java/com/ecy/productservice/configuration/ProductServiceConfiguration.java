package com.ecy.productservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 20:23
 */

@Configuration
@EnableDiscoveryClient
@EnableReactiveMongoRepositories(basePackages = "com.ecy.productservice.repository")
public class ProductServiceConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}