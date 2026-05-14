package com.example.moviemaster.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;

    @NotBlank
    private String title;

    @NotBlank
    private String director;

    @NotBlank
    private String genre;

    @Positive
    private double budget;

    @PastOrPresent
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private ProductionHouse productionHouse;

    public Film() {
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ProductionHouse getProductionHouse() {
        return productionHouse;
    }

    public void setProductionHouse(ProductionHouse productionHouse) {
        this.productionHouse = productionHouse;
    }
}