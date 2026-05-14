package com.example.moviemaster.service;

import com.example.moviemaster.entity.Film;

import java.util.List;

public interface FilmService {

    Film addFilm(Film film);

    List<Film> getByDirectorAndGenre(String director, String genre);

    List<Film> getByProductionHouse(String name);

    void deleteFilm(Long id);
}