package com.example.springapp.model;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
public enum Role {
  ADMIN(Collections.emptySet()),
  AGENT(
      Set.of(
          Permission.CUSTOMER_READ,
          Permission.CUSTOMER_UPDATE,
          Permission.CUSTOMER_DELETE,
          Permission.CUSTOMER_CREATE,
          Permission.AGENT_READ,
          Permission.AGENT_UPDATE,
          Permission.AGENT_DELETE,
          Permission.AGENT_CREATE)),
  CUSTOMER(
      Set.of(
          Permission.CUSTOMER_READ,
          Permission.CUSTOMER_UPDATE,
          Permission.CUSTOMER_DELETE,
          Permission.CUSTOMER_CREATE));

  @Getter
  private final Set<Permission> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
        .stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
