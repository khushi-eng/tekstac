package com.example.moviemaster.service.impl;

import com.example.moviemaster.entity.Film;
import com.example.moviemaster.repository.FilmRepository;
import com.example.moviemaster.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;

    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public Film addFilm(Film film) {
        return repository.save(film);
    }

    @Override
    public List<Film> getByDirectorAndGenre(String director, String genre) {
        return repository.findByDirectorAndGenre(director, genre);
    }

    @Override
    public List<Film> getByProductionHouse(String name) {
        return repository.findByProductionHouseProductionHouseNameIgnoreCase(name);
    }

    @Override
    public void deleteFilm(Long id) {
        repository.deleteById(id);
    }
}