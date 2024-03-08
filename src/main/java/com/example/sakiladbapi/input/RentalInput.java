package com.example.sakiladbapi.input;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RentalInput {
    @Column(name = "rental_date")
    private Timestamp rentalDate;

    @Column(name = "inventory_id")
    private Short inventoryId;

    @Column(name = "customer_id")
    private Short customerId;

    @Column(name = "return_date")
    private Timestamp returnDate;

    @Column(name = "staff_id")
    private Short staffId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}
