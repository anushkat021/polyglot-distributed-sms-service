package com.anushka.polyglot_service.dto;

import lombok.Data;

@Data
public class SmsRequest {
  private String phoneNumber;
  private String message;

}
