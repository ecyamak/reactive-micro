package com.ecy.smsservice.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ecyamak
 * Date: 14.07.2023
 * Time: 07:59
 */

@Configuration
public class SMSServiceConfiguration {

    @Bean
    public AmazonSNSClient amazonSNSClient(@Value("${sns.access.key:null}") String accessKey,
                                           @Value("${sns.secret.key:null}") String secretKey) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return (AmazonSNSClient) AmazonSNSClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}