package com.ticolls.web_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticolls.web_service.dtos.ProductResponseDTO;
import com.ticolls.web_service.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {

        List<ProductResponseDTO> products = service.findAll();

        return ResponseEntity.ok().body(products);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {

        ProductResponseDTO product = service.findById(id);

        return ResponseEntity.ok().body(product);

    }
}
