package com.ticolls.web_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticolls.web_service.dtos.CategoryResponseDTO;
import com.ticolls.web_service.entities.Category;
import com.ticolls.web_service.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<CategoryResponseDTO> findAll() {
        List<Category> categories = repository.findAll();

        List<CategoryResponseDTO> categoriesDTO = new ArrayList<>();

        for (Category category : categories) {
            categoriesDTO.add(new CategoryResponseDTO(category));
        }

        return categoriesDTO;
    }

    public CategoryResponseDTO findById(Long id) {
        Optional<Category> optionalCategory = repository.findById(id);

        return new CategoryResponseDTO(optionalCategory.get());
    }
} 
 