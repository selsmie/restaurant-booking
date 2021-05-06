package com.example.restaurantbookings.repositories;

import com.example.restaurantbookings.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
