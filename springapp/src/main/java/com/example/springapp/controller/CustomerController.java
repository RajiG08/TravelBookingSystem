package com.example.springapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Role;

@RestController
@RequestMapping("/customer")
@CrossOrigin("https://8081-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io")
public class CustomerController {


  @GetMapping("/{role}")
  public Role get(@PathVariable(value = "role")Role role) {
    return role;
  }

  @PostMapping
  public String post() {
    return "POST:: Customer controller";
  }

  @PutMapping
  public String put() {
    return "PUT:: Customer controller";
  }

  @DeleteMapping
  public String delete() {
    return "DELETE:: Customer controller";
  }
}
