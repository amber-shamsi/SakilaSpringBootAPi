package com.example.sakiladbapi.services;

import com.example.sakiladbapi.entities.Actor;
import com.example.sakiladbapi.entities.Film;
import com.example.sakiladbapi.repositories.ActorRepository;
import com.example.sakiladbapi.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.ResourceAccessException;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ActorService {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;

    public Actor createMovieLink(Short actorId, Short filmId){
        var actor = actorRepository.findById(actorId).orElseThrow(()
                -> new ResourceAccessException("No actor could be found with that id."));
        var movie = filmRepository.findById(filmId).orElseThrow(()
                -> new ResourceAccessException("No Movie could be found with that id."));

        actor.getFilms().add(movie);
        return actorRepository.save(actor);
    }

    public Actor deleteMovieLink(Short actorId, Short filmId) {
        var actor = actorRepository.findById(actorId).orElseThrow(()
                -> new ResourceAccessException("No actor could be found with that id."));
        var movie = actor.getFilms().stream().filter(a -> Objects.equals(a.getId(), filmId)).toList().getFirst();
        if (movie == null) {
            throw new ResourceAccessException("No movie with that id could be found.");
        }

        actor.getFilms().remove(movie);
        return actorRepository.save(actor);
    }
}