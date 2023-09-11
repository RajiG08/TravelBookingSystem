package com.example.springapp.repository;

import com.example.springapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
  @Query("SELECT h FROM Hotel h WHERE " +
      "(:location IS NULL OR h.location = :location) " +
      "AND ((:checkInDate IS NULL OR :checkOutDate IS NULL) " +
      "OR ( h.checkOutDate <= :checkInDate)" +
      "OR (h.checkInDate IS NULL OR h.checkOutDate IS NULL))")
  List<Hotel> searchHotels(@Param("location") String location,
      @Param("checkInDate") LocalDate checkInDate,
      @Param("checkOutDate") LocalDate checkOutDate);

}
