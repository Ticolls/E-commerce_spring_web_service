package com.ticolls.web_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticolls.web_service.entities.Category;
import com.ticolls.web_service.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> categorys = service.findAll();

        return ResponseEntity.ok().body(categorys);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        Category category = service.findById(id);

        return ResponseEntity.ok().body(category);

    }
}
