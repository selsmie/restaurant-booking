package com.example.restaurantbookings.components;

import com.example.restaurantbookings.models.Guest;
import com.example.restaurantbookings.models.Reservation;
import com.example.restaurantbookings.models.Restaurant;
import com.example.restaurantbookings.repositories.GuestRepository;
import com.example.restaurantbookings.repositories.ReservationRepository;
import com.example.restaurantbookings.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ReservationRepository reservationRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Guest simon = new Guest("Simon", "Elsmie", "07825177555", "simonelsmie@hotmail.com");
        guestRepository.save(simon);

        Restaurant diner = new Restaurant("The Diner", 20, "01764 662231", "diner@example.com");
        restaurantRepository.save(diner);

        String notes = "this is a test for notes";

        Reservation test = new Reservation(2, "2021-05-06", "18:30", simon, diner, notes);
        reservationRepository.save(test);
    }
}
