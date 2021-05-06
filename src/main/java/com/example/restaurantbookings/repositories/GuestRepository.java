package com.example.restaurantbookings.repositories;

import com.example.restaurantbookings.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
