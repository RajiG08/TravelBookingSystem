package com.example.springapp.service;

import com.example.springapp.model.Flight;
import com.example.springapp.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> fetchFlight() {
        return flightRepository.findAll();
    }

    @Override
    public Flight fetchFlightById(Long flightNumber) {
        return flightRepository.findById(flightNumber).get();
    }

    @Override
    public void deleteFlightById(Long flightNumber) {
        flightRepository.deleteById(flightNumber);
    }

    @Override
    public Flight updateFlight(Long flightNumber, Flight flight) {
        Flight flightDB = flightRepository.findById(flightNumber).get();

        if (Objects.nonNull(flight.getFromLocation()) &&
                !"".equalsIgnoreCase(flight.getFromLocation())) {
            flightDB.setFromLocation(flight.getFromLocation());
        }

        if (Objects.nonNull(flight.getAirline()) &&
                !"".equalsIgnoreCase(flight.getAirline())) {
            flightDB.setAirline(flight.getAirline());
        }
        if (Objects.nonNull(flight.getDropLocation()) &&
                !"".equalsIgnoreCase(flight.getDropLocation())) {
            flightDB.setDropLocation(flight.getDropLocation());
        }
        if (Objects.nonNull(flight.getDepartureDate())) {
            flightDB.setDepartureDate(flight.getDepartureDate());
        }
        if (Objects.nonNull(flight.getArrivalDate())) {
            flightDB.setArrivalDate(flight.getArrivalDate());
        }
        if (Objects.nonNull(flight.getPrice())) {
            flightDB.setPrice(flight.getPrice());
        }

        return flightRepository.save(flightDB);
    }

    @Override
    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> fetchFlightSeat() {
        return flightRepository.findAll();
    }
}
