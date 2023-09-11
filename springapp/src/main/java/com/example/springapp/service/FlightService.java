package com.example.springapp.service;

import com.example.springapp.model.Flight;

import java.util.List;

public interface FlightService {

    public Flight saveFlight(Flight flight);

    List<Flight> fetchFlight();

    Flight fetchFlightById(Long flightNumber);

    void deleteFlightById(Long flightNumber);

    Flight updateFlight(Long flightNumber, Flight flight);

    public Flight create(Flight flight);

    public List<Flight> fetchFlightSeat();
}
