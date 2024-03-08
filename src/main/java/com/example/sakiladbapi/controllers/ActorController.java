package com.example.sakiladbapi.controllers;

import com.example.sakiladbapi.input.ActorInput;
import com.example.sakiladbapi.models.FilmModel;
import com.example.sakiladbapi.repositories.ActorRepository;
import com.example.sakiladbapi.entities.Actor;
import com.example.sakiladbapi.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public List<Actor> getActorList(){
        return actorRepository.findAll();
    }
    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable Short id){
        return actorRepository.findById(id).orElseThrow(()
                -> new ResourceAccessException("No Actor could be found with that id."));
    }

    @PostMapping("actors")
    public Actor createActor(@Validated @RequestBody ActorInput request){
        final var actor = new Actor();
        actor.setFirstName(request.getFirstName());
        actor.setLastName(request.getLastName());
        return actorRepository.save(actor);
    }

    @PostMapping("actors/movies/{actorId}/{filmId}")
    public Actor createActorMovieLink(@PathVariable Short actorId, @PathVariable Short filmId){
        return actorService.createMovieLink(actorId, filmId);
    }

    @DeleteMapping("actors/movies/{actorId}/{filmId}")
    public Actor deleteActorMovieLink(@PathVariable Short actorId, @PathVariable Short filmId){
        return actorService.deleteMovieLink(actorId, filmId);
    }

    @PatchMapping("actors/{id}")
    public Actor updateActor(@PathVariable Short id, @Validated @RequestBody ActorInput request){
        Actor actor = actorRepository.findById(id).orElseThrow();
        actor.setFirstName(request.getFirstName());
        actor.setLastName(request.getLastName());
        return actorRepository.save(actor);
    }

    @DeleteMapping("actors/{id}")
    public void deleteActor(@PathVariable Short id){
        actorRepository.deleteById(id);
    }

    @GetMapping("actors/starsIn/{id}")
    public List<FilmModel> starsIn(@PathVariable Short id){
        final var actor = actorRepository.findById(id).orElseThrow();
        List<FilmModel> list = new ArrayList<FilmModel>();
        actor.getFilms().forEach((film) -> {
            FilmModel filmModel = new FilmModel(film);
            list.add(filmModel);
        });
        return list;
    }
}
