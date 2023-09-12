package com.ticolls.web_service.dtos;

import com.ticolls.web_service.entities.OrderItem;

public class OrderItemDTO {
    private Integer quantity;
    private Double price;
    private Double subTotal;
    private ProductResponseDTO product;


    public OrderItemDTO(OrderItem orderItem) {
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.subTotal = orderItem.getSubTotal();
        this.product = new ProductResponseDTO(orderItem.getProduct());
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public Double getSubTotal() {
        return this.subTotal;
    }

    public ProductResponseDTO getProduct() {
        return this.product;
    }


}
