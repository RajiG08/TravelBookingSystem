package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.exception.ResourceNotFoundException;
import com.example.springapp.model.Booking;
import com.example.springapp.model.User;
import com.example.springapp.repository.BookingRepository;
import com.example.springapp.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BookingRepository bookRepository;

  @Override
  public Booking addBooking(Booking book, int userid) {
    User user = userRepository.findById(userid)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + userid));
    book.setUser(user);
    return bookRepository.save(book);
  }

  @Override
  public List<Booking> getBookingsByUserId(int userId) {
    if (!userRepository.existsById(userId)) {
      throw new ResourceNotFoundException("User not found with ID: " + userId);
    }
    List<Booking> bookings = bookRepository.findByUserId(userId);
    return bookings;
  }

  @Override
  public void deleteBooking(int id) {
    Booking book = bookRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Booking not Found id: " + id));
    bookRepository.delete(book);
  }

}
