package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Booking;

public interface BookingService {
  public Booking addBooking(Booking book, int userid);

  List<Booking> getBookingsByUserId(int userid);

  public void deleteBooking(int id);
}
