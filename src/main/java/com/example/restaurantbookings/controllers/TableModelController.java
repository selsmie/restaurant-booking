package com.example.restaurantbookings.controllers;

import com.example.restaurantbookings.models.TableModel;
import com.example.restaurantbookings.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TableModelController {

    @Autowired
    TableRepository tableRepository;

    @GetMapping(value = "/tables")
    public ResponseEntity getAllTables() {
        return new ResponseEntity(tableRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/tables/{id}")
    public ResponseEntity<TableModel> updateTable(@RequestBody TableModel table, @PathVariable Long id) {
        TableModel foundTable = tableRepository.findById(id).get();
        foundTable.setReservations(table.getReservations());
        tableRepository.save(foundTable);
        return new ResponseEntity<>(foundTable, HttpStatus.OK);
    }
}
