package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
  List<Booking> findByUserId(int userId);

}
