package com.anushka.polyglot_service.dto;

import lombok.Data;

@Data
public class SmsResponse {
  private String status;

  public SmsResponse(String status) {
      this.status = status;
  }
}
