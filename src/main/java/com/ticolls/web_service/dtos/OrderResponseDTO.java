package com.ticolls.web_service.dtos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.ticolls.web_service.entities.Order;
import com.ticolls.web_service.entities.OrderItem;
import com.ticolls.web_service.enums.OrderStatus;


public class OrderResponseDTO {

    private Long id;
    private Instant moment;
    private OrderStatus orderStatus;
    private UserResponseDTO user;
    private Set<OrderItemDTO> items = new HashSet<>();

    public OrderResponseDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.orderStatus = order.getOrderStatus();
        this.user = new UserResponseDTO(order.getClient());
        
        for (OrderItem orderItem : order.getItems()) {
            this.items.add(new OrderItemDTO(orderItem));
        }
    }


    public Long getId() {
        return this.id;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public UserResponseDTO getUser() {
        return this.user;
    }

    public Set<OrderItemDTO> getItems() {
        return this.items;
    }

}
