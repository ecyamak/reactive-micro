package com.ecy.smsservice.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: ecyamak
 * Date: 14.07.2023
 * Time: 08:17
 */

@Slf4j
@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SMSRestController {

    private final AmazonSNSClient amazonSNSClient;

    @Value("${sns.topic.arn:null}")
    private String topic;


    @GetMapping("/subscribe")
    public Mono<Void> subscribe(@RequestParam String phoneNumber) {
        try {
            SubscribeRequest subscribeRequest = new SubscribeRequest(topic, "sms", phoneNumber);
            SubscribeResult subscribeResult = amazonSNSClient.subscribe(subscribeRequest);
            log.info("Subscription ARN: " + subscribeResult.getSubscriptionArn() + "\n\n Status is " + subscribeResult.getSdkHttpMetadata().getHttpStatusCode());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            return Mono.empty();
        }
    }

    @GetMapping("/send")
    public Mono<Void> send(@RequestParam String message) {
        try {
            Map<String, MessageAttributeValue> smsAttributes = new HashMap<>();
            smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                    .withStringValue("Transactional")
                    .withDataType("String"));
            PublishResult result = amazonSNSClient.publish(new PublishRequest()
                    .withMessage(message)
                    .withTopicArn(topic)
                    .withMessageAttributes(smsAttributes));
            log.info(result.getMessageId() + "Message sent. Status was " + result.getSdkHttpMetadata().getHttpStatusCode());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            return Mono.empty();
        }
    }


}