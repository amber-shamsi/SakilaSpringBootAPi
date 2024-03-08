package com.example.sakiladbapi.repositories;

import com.example.sakiladbapi.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Short> {
}
