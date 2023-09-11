package com.example.springapp.repository;

import com.example.springapp.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

  @Query("SELECT h FROM Flight h WHERE " +
      "(:fromLocation IS NULL OR h.fromLocation = :fromLocation) " +
      "AND (:dropLocation IS NULL OR h.dropLocation = :dropLocation) " +
      "AND (:departureDate IS NULL OR h.departureDate = :departureDate) ")

  List<Flight> searchFlights(@Param("fromLocation") String fromLocation,
      @Param("dropLocation") String toLocation,
      @Param("departureDate") LocalDate departureDate);

}
