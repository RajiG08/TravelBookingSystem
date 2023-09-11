package com.example.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class FlightNotFoundAdvice {
  @ResponseBody
  @ExceptionHandler(FlightNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  // if we get UserNotFoundException.class then make request to this controller

  public Map<String, String> exceptionHandler(FlightNotFoundException exception) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("errorMessage", exception.getMessage());
    return errorMap;
  }
}