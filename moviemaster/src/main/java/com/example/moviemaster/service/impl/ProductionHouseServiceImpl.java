package com.example.moviemaster.service.impl;

import com.example.moviemaster.entity.ProductionHouse;
import com.example.moviemaster.exception.ResourceNotFoundException;
import com.example.moviemaster.repository.ProductionHouseRepository;
import com.example.moviemaster.service.ProductionHouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionHouseServiceImpl implements ProductionHouseService {

    private final ProductionHouseRepository repository;

    public ProductionHouseServiceImpl(ProductionHouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductionHouse addProductionHouse(ProductionHouse house) {
        return repository.save(house);
    }

    @Override
    public ProductionHouse updateChairman(Long id, String chairman) {

        ProductionHouse house = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Production House not found"));

        house.setChairmanName(chairman);

        return repository.save(house);
    }

    @Override
    public ProductionHouse getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Production House not found"));
    }

    @Override
    public List<ProductionHouse> getByFilmCount(int count) {
        return repository.findByFilmsSizeGreaterThanEqual(count);
    }
}