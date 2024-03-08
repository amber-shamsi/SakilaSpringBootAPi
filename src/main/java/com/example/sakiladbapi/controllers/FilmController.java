package com.example.sakiladbapi.controllers;

import com.example.sakiladbapi.entities.Actor;
import com.example.sakiladbapi.entities.Film;
import com.example.sakiladbapi.input.ActorInput;
import com.example.sakiladbapi.input.FilmInput;
import com.example.sakiladbapi.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    FilmRepository filmRepository;

    @GetMapping("films")
    public List<Film> getFilms(){
        return filmRepository.findAll();
    }

    @PostMapping("films")
    public Film createFilm(@Validated @RequestBody FilmInput request){
        Film film = new Film();
        MapFromRequest(film, request);
        return filmRepository.save(film);
    }

    @PatchMapping("films/{id}")
    public Film updateActor(@PathVariable Short id, @Validated @RequestBody FilmInput request){
        Film film = filmRepository.findById(id).orElseThrow();
        film = MapFromRequest(film, request);
        return filmRepository.save(film);
    }

    @DeleteMapping("films/{id}")
    public void deleteActor(@PathVariable Short id){
        filmRepository.deleteById(id);
    }

    public Film MapFromRequest(Film film, FilmInput request){
        if (request.getTitle() != null) {
            film.setTitle(request.getTitle());
        }if (request.getDescription() != null) {
            film.setDescription(request.getDescription());
        }if (request.getReleaseYear() != null) {
            film.setReleaseYear(request.getReleaseYear());
        }if (request.getLanguageId() != null) {
            film.setLanguageId(request.getLanguageId());
        }if (request.getRentalDuration() != null) {
            film.setRentalDuration(request.getRentalDuration());
        }if (request.getRentalRate() != null) {
            film.setRentalRate(request.getRentalRate());
        }if (request.getLength() != null) {
            film.setLength(request.getLength());
        }if (request.getReplacementCost() != null) {
            film.setReplacementCost(request.getReplacementCost());
        }if (request.getLastUpdated() != null) {
            film.setLastUpdated(request.getLastUpdated());
        }
        return film;
    }
}
