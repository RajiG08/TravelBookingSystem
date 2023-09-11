package com.example.springapp.service;

import java.util.*;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springapp.model.User;

public interface JwtService {
  public String extractUsername(String token);

  public String generateToken(User userDetails, UserDetails userD);

  public <T> T extractClaim(String token, Function<Claims, T> claimResolver);

  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

  public boolean isTokenValid(String token, UserDetails userDetails);
}
