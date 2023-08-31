package com.ticolls.web_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticolls.web_service.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long>{
    
}
