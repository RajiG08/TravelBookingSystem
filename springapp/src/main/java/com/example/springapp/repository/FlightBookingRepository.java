package com.example.springapp.repository;

import com.example.springapp.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking,Long> {
}
