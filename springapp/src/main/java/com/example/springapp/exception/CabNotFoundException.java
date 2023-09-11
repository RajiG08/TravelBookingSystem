package com.example.springapp.exception;

public class CabNotFoundException extends RuntimeException {

  public CabNotFoundException(Long id) {
    super("Could not found the car with id " + id);
  }
}
