package com.example.moviemaster.repository;

import com.example.moviemaster.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByDirectorAndGenre(String director, String genre);

    List<Film> findByProductionHouseProductionHouseNameIgnoreCase(String name);
}