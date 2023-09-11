package com.example.springapp.repository;

import com.example.springapp.model.CabBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabBookingRepository extends JpaRepository<CabBooking, Long> {

}
