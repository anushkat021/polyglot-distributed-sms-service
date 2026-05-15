package com.anushka.polyglot_service.vendor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.anushka.polyglot_service.dto.SmsRequest;

@Service
public class MockVendorService {
  public String sendSms(@RequestBody SmsRequest request) {

      System.out.println(
          "Sending SMS to " + request.getPhoneNumber()
      );

      return "SUCCESS";
  }
}
