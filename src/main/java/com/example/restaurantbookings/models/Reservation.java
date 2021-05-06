package com.example.restaurantbookings.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "covers")
    private int covers;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    @JsonIgnoreProperties({"reservations"})
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnoreProperties({"reservations"})
    private Restaurant restaurant;

    @Column(name = "status")
    private String status;

    public Reservation() {
        this.status = "booked";
    }

    public Reservation(int covers, String date, String time, Guest guest, Restaurant restaurant, String notes) {
        this.covers = covers;
        this.date = date;
        this.time = time;
        this.guest = guest;
        this.restaurant = restaurant;
        this.notes = notes;
        this.status = "booked";
    }

    public Reservation(int covers, String date, String time, Guest guest, Restaurant restaurant) {
        this.covers = covers;
        this.date = date;
        this.time = time;
        this.guest = guest;
        this.restaurant = restaurant;
        this.status = "booked";
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getCovers() {
        return covers;
    }

    public void setCovers(int covers) {
        this.covers = covers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
