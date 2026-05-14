package com.example.moviemaster.repository;

import com.example.moviemaster.entity.ProductionHouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionHouseRepository extends JpaRepository<ProductionHouse, Long> {

    ProductionHouse findByProductionHouseNameIgnoreCase(String name);

    List<ProductionHouse> findByFilmsSizeGreaterThanEqual(int count);
}