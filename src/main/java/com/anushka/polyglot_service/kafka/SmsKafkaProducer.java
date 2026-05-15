package com.anushka.polyglot_service.kafka;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;

import com.anushka.polyglot_service.dto.SmsRequest;

public class SmsKafkaProducer {
  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  public void publishEvent(@RequestBody SmsRequest request,
                            String status) {

      Map<String, Object> event = new HashMap<>();

      event.put("phoneNumber",
              request.getPhoneNumber());

      event.put("message",
              request.getMessage());

      event.put("status", status);

      kafkaTemplate.send("sms-topic", event);
  }
}
