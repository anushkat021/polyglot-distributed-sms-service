package com.anushka.polyglot_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.anushka.polyglot_service.blocklist.BlockListService;
import com.anushka.polyglot_service.dto.SmsRequest;
import com.anushka.polyglot_service.dto.SmsResponse;
import com.anushka.polyglot_service.kafka.SmsKafkaProducer;
import com.anushka.polyglot_service.vendor.MockVendorService;

@Service
public class SmsService {
  @Autowired
  private BlockListService blockListService;

  @Autowired
  private MockVendorService vendorService;

  @Autowired
  private SmsKafkaProducer kafkaProducer;

  public SmsResponse sendSms(@RequestBody SmsRequest request) {

      if(blockListService.isBlocked(
              request.getPhoneNumber())) {

          return new SmsResponse("BLOCKED");
      }

      String vendorStatus =
              vendorService.sendSms(request);

      // kafkaProducer.publishEvent(
      //         request,
      //         vendorStatus
      // );
      kafkaProducer.sendMessage(
          request.getPhoneNumber() +
          " : " +
          request.getMessage()
      );

      return new SmsResponse(vendorStatus);
  }
}
