package com.example.restaurantbookings.controllers;

import com.example.restaurantbookings.models.Reservation;
import com.example.restaurantbookings.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping(value = "/reservations")
    public ResponseEntity getAllReservations(){
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/reservations/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id){
        return new ResponseEntity(reservationRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/reservations/{id}")
    public ResponseEntity<Reservation> updateReservations(@RequestBody Reservation reservation, @PathVariable Long id){
        Reservation foundReservation = reservationRepository.findById(id).get();
        foundReservation.setCovers(reservation.getCovers());
        foundReservation.setDate(reservation.getDate());
        foundReservation.setGuest(reservation.getGuest());
        foundReservation.setTime(reservation.getTime());
        foundReservation.setNotes(reservation.getNotes());
        foundReservation.setRestaurant(reservation.getRestaurant());
        foundReservation.setStatus(reservation.getStatus());
        foundReservation.setTable(reservation.getTable());
        reservationRepository.save(foundReservation);
        return new ResponseEntity(foundReservation, HttpStatus.OK);
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity<Reservation> postRestaurant(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/reservations/{id}")
    public ResponseEntity<Reservation> deleteRestaurant(@PathVariable Long id){
        reservationRepository.deleteById(id);
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/reservations/{id}/depart")
    public ResponseEntity<Reservation> departReservation(@RequestBody Reservation reservation, @PathVariable Long id) {
        Reservation foundReservation = reservationRepository.findById(id).get();
        foundReservation.setStatus(reservation.getStatus());
        foundReservation.removeTable();
        reservationRepository.save(foundReservation);
        return new ResponseEntity(foundReservation, HttpStatus.OK);
    }
}
