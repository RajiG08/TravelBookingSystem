package com.example.springapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
  CUSTOMER_READ("customer:read"),
  CUSTOMER_UPDATE("customer:update"),
  CUSTOMER_CREATE("customer:create"),
  CUSTOMER_DELETE("customer:delete"),
  AGENT_READ("agent:read"),
  AGENT_UPDATE("agent:update"),
  AGENT_CREATE("agent:create"),
  AGENT_DELETE("agent:delete");

  @Getter
  private final String permission;
}
