package com.example.springapp.repository;

import com.example.springapp.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookingRepository extends JpaRepository<HotelBooking,Long> {

}
