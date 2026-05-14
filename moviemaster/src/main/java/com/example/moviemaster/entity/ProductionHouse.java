package com.example.moviemaster.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
public class ProductionHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;

    @NotBlank
    private String productionHouseName;

    @Min(1800)
    private int establishedYear;

    @NotBlank
    private String chairmanName;

    @NotBlank
    private String country;

    @OneToMany(mappedBy = "productionHouse", cascade = CascadeType.ALL)
    private List<Film> films;

    public ProductionHouse() {
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getProductionHouseName() {
        return productionHouseName;
    }

    public void setProductionHouseName(String productionHouseName) {
        this.productionHouseName = productionHouseName;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getChairmanName() {
        return chairmanName;
    }

    public void setChairmanName(String chairmanName) {
        this.chairmanName = chairmanName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}