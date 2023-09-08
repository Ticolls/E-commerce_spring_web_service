package com.ticolls.web_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticolls.web_service.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{
    
}
