package com.example.springapp.controller;

import com.example.springapp.exception.CabNotFoundException;
import com.example.springapp.model.Cab;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.springapp.model.CabBooking;
import com.example.springapp.repository.CabBookingRepository;
import com.example.springapp.repository.CabRepository;
import com.example.springapp.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin("https://8081-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io")
@RequestMapping("/rental_cars")

@RestController
public class CabController {
  @Autowired

  private CabService cabService;
  @Autowired
  private final CabRepository cabRepository;
  @Autowired
  private CabBookingRepository cabBookingRepository;

  public CabController(CabRepository cabRepository) {
    this.cabRepository = cabRepository;
  }

  @PostMapping("/cabs")
  public Cab saveDepartment(@RequestBody Cab cab) {
    return cabService.saveCab(cab);

  }

  @GetMapping("/cabs/search")
  public List<Cab> searchCabs(@RequestParam(value = "pickUpLocation", required = false) String pickUpLocation,
      @RequestParam(value = "dropLocation", required = false) String dropLocation,
      @RequestParam(value = "pickUpDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate pickUpDate,
      @RequestParam(value = "dropOffDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dropOffDate) {

    // Check if any search criteria is provided
    if (pickUpLocation == null && dropLocation == null && pickUpDate == null && dropOffDate == null) {
      // No search criteria provided, return all cabs
      return cabRepository.findAll();

    }

    // Perform search logic based on the specified criteria
    List<Cab> cabs = cabRepository.searchCabs(pickUpLocation, dropLocation, pickUpDate, dropOffDate);
    return cabs;
  }

  @PostMapping("/cabs/book")
  public CabBooking bookCab(@RequestBody CabBooking cabBooking) {
    return cabBookingRepository.save(cabBooking);
  }

  @GetMapping("/cabs/manage")
  public List<CabBooking> manageBookings() { // @RequestParam("user-id") Long customerId) {
    // Retrieve and return the list of cab bookings associated with the specified
    // user ID
    // List<CabBookingRequest> bookings =
    // cabBookingRepository.findByCustomerId(customerId);
    return cabBookingRepository.findAll();
  }

  @GetMapping("/cabs/{cabId}")
  Optional<Cab> getCabById(@PathVariable Long cabId) {
    return cabRepository.findById(cabId);
  }

  @PutMapping("/cabs/{cabId}")
  Cab updateCab(@RequestBody Cab cabRequest, @PathVariable Long cabId) {
    return cabRepository.findById(cabId)
        .map(cab -> {
          cab.setCabType(cabRequest.getCabType());
          cab.setCabPrice(cabRequest.getCabPrice());
          return cabRepository.save(cab);
        }).orElseThrow(() -> new CabNotFoundException(cabId));
  }

  @DeleteMapping("/cabs/{cabId}")
  String deleteCab(@PathVariable Long cabId) {
    if (!cabRepository.existsById(cabId)) {
      throw new CabNotFoundException(cabId);
    }
    // Cab cab = cabRepository.findById(cabId)
    // .orElseThrow(() -> new CabNotFoundException(cabId));
    cabRepository.deleteById(cabId);
    return "User with id " + cabId + " has been deleted successfully!";
  }

}
