package com.example.sakiladbapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Short rentalId;

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
