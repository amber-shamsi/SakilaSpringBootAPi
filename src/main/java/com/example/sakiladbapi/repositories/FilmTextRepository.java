package com.example.sakiladbapi.repositories;

import com.example.sakiladbapi.entities.FilmText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmTextRepository extends JpaRepository<FilmText, Short> {
}
