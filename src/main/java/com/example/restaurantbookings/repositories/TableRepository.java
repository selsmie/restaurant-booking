package com.example.restaurantbookings.repositories;

import com.example.restaurantbookings.models.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<TableModel, Long> {
}
