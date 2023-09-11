package com.example.springapp.repository;

import com.example.springapp.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {
        @Query("SELECT h FROM Cab h WHERE " +
                        "(:pickUpLocation IS NULL OR h.pickUpLocation = :pickUpLocation) " +
                        "AND (:dropLocation IS NULL OR h.dropLocation = :dropLocation) " +
                        "AND ((:pickUpDate IS NULL OR :dropOffDate IS NULL) " +
                        "OR ( h.dropOffDate <= :pickUpDate))")

        List<Cab> searchCabs(@Param("pickUpLocation") String pickUpLocation,
                        @Param("dropLocation") String dropLocation,
                        @Param("pickUpDate") LocalDate pickUpDate,
                        @Param("dropOffDate") LocalDate dropOffDate);
}
