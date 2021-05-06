package com.example.restaurantbookings.controllers;

import com.example.restaurantbookings.models.Restaurant;
import com.example.restaurantbookings.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping(value = "/restaurants")
    public ResponseEntity getAllRestaurants(){
        return new ResponseEntity(restaurantRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable Long id){
        Restaurant foundRestaurant = restaurantRepository.findById(id).get();
        foundRestaurant.setName(restaurant.getName());
        foundRestaurant.setCapacity(restaurant.getCapacity());
        foundRestaurant.setReservations(restaurant.getReservations());
        foundRestaurant.setEmail(restaurant.getEmail());
        foundRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantRepository.save(foundRestaurant);
        return new ResponseEntity(foundRestaurant, HttpStatus.OK);
    }

    @PostMapping(value = "/restaurants")
    public ResponseEntity<Restaurant> postRestaurant(@RequestBody Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return new ResponseEntity(restaurantRepository.findAll(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable Long id){
        restaurantRepository.deleteById(id);
        return new ResponseEntity(restaurantRepository.findAll(), HttpStatus.OK);
    }
}
