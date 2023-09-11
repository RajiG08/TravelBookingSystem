package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class CabBooking {
  @Id
  @GeneratedValue

  private Long BookingId;
  private Long CabId;
  private String custName;
  private LocalDate dropDate;
  private String custGender;
  private String custEmail;
  private int custPhone;
  private String custAddress;
  private boolean paymentStatus;
  private LocalDate pickupDate;
  private String pickupLocation;
  private String dropLocation;
  private double TotalCost;

  public LocalDate getDropDate() {
    return dropDate;
  }

  public void setDropDate(LocalDate dropDate) {
    this.dropDate = dropDate;
  }

  public Long getBookingId() {
    return BookingId;
  }

  public void setBookingId(Long bookingId) {
    BookingId = bookingId;
  }

  public Long getCabId() {
    return CabId;
  }

  public void setCabId(Long cabId) {
    CabId = cabId;
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getCustGender() {
    return custGender;
  }

  public void setCustGender(String custGender) {
    this.custGender = custGender;
  }

  public String getCustEmail() {
    return custEmail;
  }

  public void setCustEmail(String custEmail) {
    this.custEmail = custEmail;
  }

  public int getCustPhone() {
    return custPhone;
  }

  public void setCustPhone(int custPhone) {
    this.custPhone = custPhone;
  }

  public String getCustAddress() {
    return custAddress;
  }

  public void setCustAddress(String custAddress) {
    this.custAddress = custAddress;
  }

  public boolean isPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(boolean paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public LocalDate getPickupDate() {
    return pickupDate;
  }

  public void setPickupDate(LocalDate pickupDate) {
    this.pickupDate = pickupDate;
  }

  public String getPickupLocation() {
    return pickupLocation;
  }

  public void setPickupLocation(String pickupLocation) {
    this.pickupLocation = pickupLocation;
  }

  public String getDropLocation() {
    return dropLocation;
  }

  public void setDropLocation(String dropLocation) {
    this.dropLocation = dropLocation;
  }

  public double getTotalCost() {
    return TotalCost;
  }

  public void setTotalCost(double totalCost) {
    TotalCost = totalCost;
  }

}
