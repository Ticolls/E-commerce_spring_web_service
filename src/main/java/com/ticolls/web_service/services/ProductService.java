package com.ticolls.web_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticolls.web_service.dtos.ProductResponseDTO;
import com.ticolls.web_service.entities.Product;
import com.ticolls.web_service.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> findAll() {

        List<Product> products = repository.findAll();

        List<ProductResponseDTO> productsDTO = new ArrayList<>();

        for (Product product : products) {
            productsDTO.add(new ProductResponseDTO(product));
        }

        return productsDTO;

    }

    public ProductResponseDTO findById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);

        return new ProductResponseDTO(optionalProduct.get());
    }
} 
 