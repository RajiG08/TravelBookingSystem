package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Booking;
import com.example.springapp.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin("https://8081-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io")
public class BookingController {

  @Autowired
  private BookingService bookService;

  @PostMapping("/{userId}")
  public ResponseEntity<Booking> autheticate(@PathVariable(value = "userId") int userId, @RequestBody Booking book) {
    return ResponseEntity.ok(bookService.addBooking(book, userId));
  };

  @GetMapping("/{userId}")
  public ResponseEntity<List<Booking>> getBookingByUserId(@PathVariable(value = "userId") int userId) {
    List<Booking> bookings = bookService.getBookingsByUserId(userId);
    return ResponseEntity.ok(bookings);
  }

  @DeleteMapping("/{userId}/{Id}")
  public void delete(@PathVariable(value = "userId") int userId, @PathVariable(value = "Id") int Id) {
    bookService.deleteBooking(Id);
  }

}
