package com.ticolls.web_service.dtos;

import com.ticolls.web_service.entities.Category;

public class CategoryResponseDTO {
    private Long id;
    private String name;

    public CategoryResponseDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
