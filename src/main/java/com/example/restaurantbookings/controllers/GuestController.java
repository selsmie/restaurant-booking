package com.example.restaurantbookings.controllers;

import com.example.restaurantbookings.models.Guest;
import com.example.restaurantbookings.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @GetMapping(value = "/guests")
    public ResponseEntity getAllGuests(){
        return new ResponseEntity(guestRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/guests/{id}")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest, @PathVariable Long id){
        Guest foundGuest = guestRepository.findById(id).get();
        foundGuest.setFirstName(guest.getFirstName());
        foundGuest.setLastName(guest.getLastName());
        foundGuest.setEmail(guest.getEmail());
        foundGuest.setPhoneNumber(guest.getPhoneNumber());
        foundGuest.setVisits(guest.getVisits());
        guestRepository.save(foundGuest);
        return new ResponseEntity<>(foundGuest, HttpStatus.OK);
    }

    @PostMapping(value = "/guests")
    public ResponseEntity<Guest> postGuest(@RequestBody Guest guest){
        guestRepository.save(guest);
        return new ResponseEntity(guestRepository.findAll(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/guests/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable Long id){
        guestRepository.deleteById(id);
        return new ResponseEntity(guestRepository.findAll(), HttpStatus.OK);
    }
}
