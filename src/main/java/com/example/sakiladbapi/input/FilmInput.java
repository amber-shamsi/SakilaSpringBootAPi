package com.example.sakiladbapi.input;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Year;

@Getter
@Setter
public class FilmInput {
    @Size(min = 1, max = 128)
    private String title;

    private String description;

    @Column(name = "release_year")
    private Year releaseYear;

    @Column(name = "language_id")
    private Short languageId;

    @Column(name = "rental_duration")
    private Short rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    private Short length;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    @Column(name = "last_update")
    private Timestamp lastUpdated;
}
