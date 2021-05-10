package com.example.restaurantbookings.components;

import com.example.restaurantbookings.models.Guest;
import com.example.restaurantbookings.models.Reservation;
import com.example.restaurantbookings.models.Restaurant;
import com.example.restaurantbookings.models.TableModel;
import com.example.restaurantbookings.repositories.GuestRepository;
import com.example.restaurantbookings.repositories.ReservationRepository;
import com.example.restaurantbookings.repositories.RestaurantRepository;
import com.example.restaurantbookings.repositories.TableRepository;
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

    @Autowired
    TableRepository tableRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Guest simon = new Guest("Simon", "Elsmie", "07711222333", "simone@example.com");
        guestRepository.save(simon);

        Guest tom = new Guest("Tom", "Bombadil", "07822999777", "tom-not@thepony.com");
        guestRepository.save(tom);

        Guest will = new Guest("Will", "Maker", "07544777666", "will@notready.co.uk");
        guestRepository.save(will);

        Restaurant diner = new Restaurant("The Diner", 18, "01764 662231", "diner@example.com");
        restaurantRepository.save(diner);

        String notes = "Birthday celebration";
        String notes1 = "Allergy to shellfish";

        Reservation booking1 = new Reservation(2, "2021-05-06", "18:30", simon, diner);
        reservationRepository.save(booking1);

        Reservation booking2 = new Reservation(1, "2021-05-06", "19:30", tom, diner, notes1);
        reservationRepository.save(booking2);

        Reservation booking3 = new Reservation(4, "2021-05-06", "20:00", will, diner, notes);
        reservationRepository.save(booking3);

        TableModel table1 = new TableModel(1, 4, "round");
        tableRepository.save(table1);

        TableModel table2 = new TableModel(2, 2, "square");
        tableRepository.save(table2);

        TableModel table3 = new TableModel(3, 2, "square");
        tableRepository.save(table3);

        TableModel table4 = new TableModel(4, 6, "round");
        tableRepository.save(table4);

        TableModel table5 = new TableModel(5, 4, "square");
        tableRepository.save(table5);

//        booking1.setTable(table2);
//        reservationRepository.save(booking1);
//
//        booking3.setTable(table1);
//        reservationRepository.save(booking3);
//
//        booking2.setTable(table3);
//        reservationRepository.save(booking2);
//
//        booking2.removeTable();
//        reservationRepository.save(booking2);
    }
}
