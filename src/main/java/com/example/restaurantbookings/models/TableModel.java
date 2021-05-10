package com.example.restaurantbookings.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tables")
public class TableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "number")
    private int number;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "shape")
    private String shape;

    @OneToMany
    @JoinColumn(name = "table_id")
    @JsonIgnoreProperties({"table"})
    private List<Reservation> reservations;

    public TableModel() {
        this.reservations = new ArrayList<>();
    }

    public TableModel(int number, int capacity, String shape) {
        this.number = number;
        this.capacity = capacity;
        this.shape = shape;
        this.reservations = new ArrayList<>();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
