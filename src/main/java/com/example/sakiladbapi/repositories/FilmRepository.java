package com.example.sakiladbapi.repositories;

import com.example.sakiladbapi.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Short> {
}
