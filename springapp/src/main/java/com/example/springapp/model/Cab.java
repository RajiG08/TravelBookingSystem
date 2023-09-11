package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Cab {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private Long cabId;
  private String cabType;
  private String pickUpLocation;

  private String dropLocation;
  private double cabPrice;
  private LocalDate pickUpDate;
  private LocalDate dropOffDate;

  public Cab(LocalDate dropOffDate) {
    this.dropOffDate = dropOffDate;
  }

  public LocalDate getPickUpDate() {
    return pickUpDate;
  }

  public void setPickUpDate(LocalDate pickUpDate) {
    this.pickUpDate = pickUpDate;
  }

  public Long getCabId() {
    return cabId;
  }

  public void setCabId(Long cabId) {
    this.cabId = cabId;
  }

  public String getCabType() {
    return cabType;
  }

  public void setCabType(String cabType) {
    this.cabType = cabType;
  }

  public String getPickUpLocation() {
    return pickUpLocation;
  }

  public void setPickUpLocation(String pickUpLocation) {
    this.pickUpLocation = pickUpLocation;
  }

  public String getDropLocation() {
    return dropLocation;
  }

  public void setDropLocation(String dropLocation) {
    this.dropLocation = dropLocation;
  }

  public double getCabPrice() {
    return cabPrice;
  }

  public void setCabPrice(double cabPrice) {
    this.cabPrice = cabPrice;
  }

  public Cab(Long cabId, String cabType, String pickUpLocation, String dropLocation, Long cabPrice) {
    this.cabId = cabId;
    this.cabType = cabType;
    this.pickUpLocation = pickUpLocation;
    this.dropLocation = dropLocation;
    this.cabPrice = cabPrice;
  }

  public Cab() {
  }

  public LocalDate getDropOffDate() {
    return dropOffDate;
  }

  public void setDropOffDate(LocalDate dropOffDate) {
    this.dropOffDate = dropOffDate;
  }
}
