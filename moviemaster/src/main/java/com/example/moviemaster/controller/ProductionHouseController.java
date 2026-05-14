package com.example.moviemaster.controller;

import com.example.moviemaster.entity.ProductionHouse;
import com.example.moviemaster.service.ProductionHouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class ProductionHouseController {

    private final ProductionHouseService service;

    public ProductionHouseController(ProductionHouseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductionHouse> addHouse(@Valid @RequestBody ProductionHouse house) {
        return new ResponseEntity<>(service.addProductionHouse(house), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductionHouse> updateChairman(
            @PathVariable Long id,
            @RequestParam String chairman) {

        return ResponseEntity.ok(service.updateChairman(id, chairman));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionHouse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/films/{count}")
    public ResponseEntity<List<ProductionHouse>> getByFilmCount(@PathVariable int count) {
        return ResponseEntity.ok(service.getByFilmCount(count));
    }
}