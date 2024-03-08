package com.example.sakiladbapi.controllers;


import com.example.sakiladbapi.entities.Rental;
import com.example.sakiladbapi.input.RentalInput;
import com.example.sakiladbapi.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {
    @Autowired
    RentalRepository rentalRepository;

    @GetMapping("rentals")
    public List<Rental> getRentalList(){
        return rentalRepository.findAll();
    }

    @GetMapping("rentals/{id}")
    public Rental getRental(@PathVariable Short id){
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping("rentals")
    public Rental createRental(@Validated @RequestBody RentalInput request){
        Rental filmText = new Rental();
        MapFromRequest(filmText, request);
        return rentalRepository.save(filmText);
    }

    @PatchMapping("rentals/{id}")
    public Rental updateRental(@PathVariable Short id, @Validated @RequestBody RentalInput request){
        Rental rental = rentalRepository.findById(id).orElseThrow();
        rental = MapFromRequest(rental, request);
        return rentalRepository.save(rental);
    }
    @DeleteMapping("rentals/{id}")
    public void deleteRental(@PathVariable Short id){
        rentalRepository.deleteById(id);
    }

    private Rental MapFromRequest(Rental rental, RentalInput request) {
        if (request.getRentalDate() != null) {
            rental.setRentalDate(request.getRentalDate());
        }
        if (request.getReturnDate() != null) {
            rental.setRentalDate(request.getReturnDate());
        }
        if (request.getCustomerId() != null) {
            rental.setCustomerId(request.getCustomerId());
        }
        if (request.getStaffId() != null) {
            rental.setStaffId(request.getStaffId());
        }
        if (request.getInventoryId() != null) {
            rental.setInventoryId(request.getInventoryId());
        }
        if (request.getLastUpdate() != null) {
            rental.setLastUpdate(request.getLastUpdate());
        }
        return rental;
    }
}
