package com.example.sakiladbapi.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;

    private String title;

    private String description;

    @Column(name = "release_year")
    private Year releaseYear;

    @Column(name = "language_id")
    private Short languageId;

    @Column(name = "original_language_id")
    private  Short originalLanguageId;

    @Column(name = "rental_duration")
    private Short rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    private Short length;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private Timestamp lastUpdated;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")}
    )
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<Actor> cast = new ArrayList<>();
}