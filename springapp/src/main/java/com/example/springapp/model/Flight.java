package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long flightNumber;
  private String airline;
  private String fromLocation;
  private String dropLocation;
  private LocalDate departureDate;
  private LocalDate arrivalDate;
  private Long price;

  public Long getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(Long flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getAirline() {
    return airline;
  }

  public void setAirline(String airline) {
    this.airline = airline;
  }

  public String getFromLocation() {
    return fromLocation;
  }

  public void setFromLocation(String fromLocation) {
    this.fromLocation = fromLocation;
  }

  public String getDropLocation() {
    return dropLocation;
  }

  public void setDropLocation(String dropLocation) {
    this.dropLocation = dropLocation;
  }

  public LocalDate getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
  }

  public LocalDate getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(LocalDate arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  // public int getPassengers() {
  // return passengers;
  // }
  //
  // public void setPassengers(int passengers) {
  // this.passengers = passengers;
  // }

  public Flight(Long flightNumber, String airline, String origin, String destination, LocalDate departureDate,
      LocalDate arrivalDate, Long price) {
    this.flightNumber = flightNumber;
    this.airline = airline;
    this.fromLocation = origin;
    this.dropLocation = destination;
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
    this.price = price;
  }

  public Flight() {
  }

  @Override
  public String toString() {
    return "Flight{" +
        "flightNumber=" + flightNumber +
        ", airline='" + airline + '\'' +
        ", origin='" + fromLocation + '\'' +
        ", destination='" + dropLocation + '\'' +
        ", departureDate=" + departureDate +
        ", arrivalDate=" + arrivalDate +
        ", price=" + price +
        '}';
  }
}
