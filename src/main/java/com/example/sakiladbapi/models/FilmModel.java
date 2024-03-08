package com.example.sakiladbapi.models;

import com.example.sakiladbapi.entities.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Year;

@Getter
@Setter
public class FilmModel {

    private String title;

    private String description;

    @Column(name = "release_year")
    private Year releaseYear;

    private Short length;

    public FilmModel(Film film){
            this.title = film.getTitle();
            this.description = film.getDescription();
            this.releaseYear = film.getReleaseYear();
            this.length = film.getLength();
    }

    public FilmModel(){

    }
}