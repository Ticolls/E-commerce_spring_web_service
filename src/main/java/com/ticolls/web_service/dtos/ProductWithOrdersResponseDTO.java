package com.ticolls.web_service.dtos;

import java.util.HashSet;
import java.util.Set;

import com.ticolls.web_service.entities.Category;
import com.ticolls.web_service.entities.Order;
import com.ticolls.web_service.entities.Product;

public class ProductWithOrdersResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Set<CategoryResponseDTO> categories = new HashSet<>();
    private Set<OrderResponseDTO> orders = new HashSet<>(); 


    public ProductWithOrdersResponseDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();

        for (Category category : product.getCategories()) {
            this.categories.add(new CategoryResponseDTO(category));
        }

        for (Order order : product.getOrdes()) {
            this.orders.add(new OrderResponseDTO(order));
        }
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public Set<CategoryResponseDTO> getCategories() {
        return this.categories;
    }

    public Set<OrderResponseDTO> getOrders() {
        return this.orders;
    }

}
