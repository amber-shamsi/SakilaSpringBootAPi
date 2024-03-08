package com.example.sakiladbapi.controllers;

import com.example.sakiladbapi.entities.FilmText;
import com.example.sakiladbapi.input.FilmTextInput;
import com.example.sakiladbapi.repositories.FilmTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmTextController {
@Autowired
FilmTextRepository filmTextRepository;

@GetMapping("filmTexts")
    public List<FilmText> getFilmTextList(){
    return filmTextRepository.findAll();
}

@GetMapping("filmTexts/{id}")
    public FilmText getFilmText(@PathVariable Short id){
    return filmTextRepository.findById(id).orElseThrow();
}

@PostMapping("filmTexts")
    public FilmText createFilm(@Validated @RequestBody FilmTextInput request){
    FilmText filmText = new FilmText();
        MapFromRequest(filmText, request);
        return filmTextRepository.save(filmText);
    }

    @PatchMapping("filmTexts/{id}")
    public FilmText updateActor(@PathVariable Short id, @Validated @RequestBody FilmTextInput request){
        FilmText filmText = filmTextRepository.findById(id).orElseThrow();
        filmText = MapFromRequest(filmText, request);
        return filmTextRepository.save(filmText);
    }
    @DeleteMapping("filmTexts/{id}")
    public void deleteActor(@PathVariable Short id){
        filmTextRepository.deleteById(id);
    }

    private FilmText MapFromRequest(FilmText filmText, FilmTextInput request) {
        if (request.getTitle() != null) {
            filmText.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            filmText.setDescription(request.getDescription());
        }
        return filmText;
    }
}
