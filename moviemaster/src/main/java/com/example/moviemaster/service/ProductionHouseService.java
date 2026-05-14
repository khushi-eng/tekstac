package com.example.moviemaster.service;

import com.example.moviemaster.entity.ProductionHouse;

import java.util.List;

public interface ProductionHouseService {

    ProductionHouse addProductionHouse(ProductionHouse house);

    ProductionHouse updateChairman(Long id, String chairman);

    ProductionHouse getById(Long id);

    List<ProductionHouse> getByFilmCount(int count);
}