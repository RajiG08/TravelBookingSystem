package com.example.springapp.controller;

import com.example.springapp.exception.FlightNotFoundException;
import com.example.springapp.model.Flight;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.springapp.model.FlightBooking;
import com.example.springapp.repository.FlightBookingRepository;
import com.example.springapp.repository.FlightRepository;
import com.example.springapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
@CrossOrigin("https://8081-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io")
public class FlightController {

  @Autowired
  private FlightService flightService;

  @Autowired
  private FlightRepository flightRepository;

  @Autowired
  private FlightBookingRepository flightBookingRepository;

  @PostMapping("/add")
  public Flight saveFlight(@RequestBody Flight flight) {
    return flightService.saveFlight(flight);
  }

  @GetMapping("/search")
  public List<Flight> fetchFlight() {
    return flightService.fetchFlight();
  }

  /*
   * @GetMapping("/flights/{id}")
   * public Flight fetchFlightById(@PathVariable("id") Long flightNumber){
   * return flightService.fetchFlightById(flightNumber);
   * }
   */

  @GetMapping("/byId/{id}")
  public Flight fetchFlightById(@PathVariable("id") Long flightNumber) {
    Optional<Flight> flightOptional = flightRepository.findById(flightNumber);
    if (flightOptional.isEmpty()) {
      throw new FlightNotFoundException(flightNumber);
    }
    return flightOptional.get();
  }

  /*
   * @DeleteMapping("/flights/{id}")
   * public String deleteFlightById(@PathVariable("id") Long flightNumber){
   * flightService.deleteFlightById(flightNumber);
   * return "flight deleted successsfully";
   * }
   */

  @DeleteMapping("/delete/{id}")
  public String deleteFlightById(@PathVariable("id") Long flightId) {
    Optional<Flight> flightOptional = flightRepository.findById(flightId);
    if (flightOptional.isEmpty()) {
      throw new FlightNotFoundException(flightId);
    } else {
      flightService.deleteFlightById(flightId);
      return "flight deleted succuessfully";
    }

  }

  /*
   * @PutMapping("/flights/{id}")
   * public Flight updateFlight(@PathVariable("id") Long flightNumber,@RequestBody
   * Flight flight){
   * return flightService.updateFlight(flightNumber,flight);
   * }
   */

  @PutMapping("/update/{id}")
  public Flight updateFlight(@PathVariable("id") Long flightId, @RequestBody Flight flight) {
    Optional<Flight> flightOptional = flightRepository.findById(flightId);
    if (flightOptional.isEmpty()) {
      throw new FlightNotFoundException(flightId);
    }
    return flightService.updateFlight(flightId, flight);
  }

  @PostMapping("/seats/confirm")
  public Flight create(@RequestBody Flight flight) {
    return flightService.create(flight);
  }

  @GetMapping("/seats/confirmed")
  public List<Flight> fetchFlightSeat() {
    return flightService.fetchFlightSeat();
  }

  @GetMapping("/flights/search")
  public List<Flight> searchHotels(@RequestParam(value = "fromLocation", required = false) String fromLocation,
      @RequestParam(value = "dropLocation", required = false) String toLocation,
      @RequestParam(value = "departureDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {

    // Check if any search criteria is provided
    if (fromLocation == null && toLocation == null && departureDate == null) {
      // No search criteria provided, return all hotels
      return flightRepository.findAll();
    }

    // Perform search logic based on the specified criteria
    List<Flight> flights = flightRepository.searchFlights(fromLocation, toLocation, departureDate);
    return flights;
  }

  @PostMapping("/book")
  public FlightBooking bookFlight(@RequestBody FlightBooking flightBooking) {
    return flightBookingRepository.save(flightBooking);
  }

  @GetMapping("/manage")
  public List<FlightBooking> manageBookings() { // @RequestParam("user-id") Long customerId) {
    // Retrieve and return the list of flight bookings associated with the specified
    // user ID
    // List<HotelBookingRequest> bookings =
    // hotelBookingRepository.findByCustomerId(customerId);
    return flightBookingRepository.findAll();
  }
}
