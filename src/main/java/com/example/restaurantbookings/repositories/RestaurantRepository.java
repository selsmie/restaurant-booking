package com.example.restaurantbookings.repositories;

import com.example.restaurantbookings.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
