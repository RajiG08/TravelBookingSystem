package com.example.springapp.exception;

public class FlightNotFoundException extends RuntimeException {

  public FlightNotFoundException(Long id) {
    super("Could not found the flight with id" + id);
  }
}
