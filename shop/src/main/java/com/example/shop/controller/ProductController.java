package com.example.shop.controller;

import com.example.shop.entity.Product;
import com.example.shop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getProducts(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "asc") String sortDir
    ) {

        Page<Product> products =
                productService.getProducts(page, size, sortDir);

        return ResponseEntity.ok(products);
    }
}