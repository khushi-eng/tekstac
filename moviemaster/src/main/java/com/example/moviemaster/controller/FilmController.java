package com.example.moviemaster.controller;

import com.example.moviemaster.entity.Film;
import com.example.moviemaster.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@Valid @RequestBody Film film) {
        return new ResponseEntity<>(service.addFilm(film), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Film>> getByDirectorAndGenre(
            @RequestParam String director,
            @RequestParam String genre) {

        return ResponseEntity.ok(service.getByDirectorAndGenre(director, genre));
    }

    @GetMapping("/house/{name}")
    public ResponseEntity<List<Film>> getByHouse(@PathVariable String name) {
        return ResponseEntity.ok(service.getByProductionHouse(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id) {

        service.deleteFilm(id);

        return ResponseEntity.ok("Film deleted successfully");
    }
}