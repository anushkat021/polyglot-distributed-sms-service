package com.anushka.polyglot_service.blocklist;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlockListService {

  private  List<String> blockedNumbers =
          List.of("9999999999");

  public boolean isBlocked(String phone) {

      return blockedNumbers.contains(phone);
  }
}
