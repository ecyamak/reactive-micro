package com.ecy.mailservice.configuration;

import com.ecy.notification.type.Mail;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: ecyamak
 * Date: 6.08.2023
 * Time: 03:40
 */

@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.bootstrap-servers:0.0.0.0:0}")
    private String kafkaServer;

    @Value("${spring.kafka.consumer.group-id:mail-group}")
    private String groupId;

    @Value("${spring.kafka.consumer.auto-offset-reset:earliest}")
    private String offset;

    @Bean
    public ConsumerFactory consumerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offset);
        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Mail.class);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory(configs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Mail> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Mail> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}