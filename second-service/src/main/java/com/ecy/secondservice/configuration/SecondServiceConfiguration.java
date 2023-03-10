package com.ecy.secondservice.configuration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableDiscoveryClient
@EnableReactiveMongoRepositories(basePackages = "com.ecy.secondservice.repository")
public class SecondServiceConfiguration {

}
