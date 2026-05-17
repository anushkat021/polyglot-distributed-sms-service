package com.anushka.polyglot_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SmsKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {

        kafkaTemplate.send("sms-topic", message);

        System.out.println(
                "Message sent to Kafka: " + message
        );
    }
}