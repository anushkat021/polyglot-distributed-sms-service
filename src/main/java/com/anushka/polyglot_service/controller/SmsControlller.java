package com.anushka.polyglot_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anushka.polyglot_service.dto.SmsRequest;
import com.anushka.polyglot_service.dto.SmsResponse;
import com.anushka.polyglot_service.service.SmsService;

@RestController
@RequestMapping("/v1/sms")
public class SmsControlller {

  @Autowired
  private SmsService smsService;

  @PostMapping("/send")
  public SmsResponse sendSms(@RequestBody SmsRequest request) {

      return smsService.sendSms(request);
  } 
}
