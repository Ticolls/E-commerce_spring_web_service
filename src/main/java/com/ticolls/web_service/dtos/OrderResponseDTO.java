package com.ticolls.web_service.dtos;

import java.time.Instant;

import com.ticolls.web_service.entities.Order;
import com.ticolls.web_service.enums.OrderStatus;


public class OrderResponseDTO {

    private Long id;
    private Instant moment;
    private OrderStatus orderStatus;
    private Long userId;

    public OrderResponseDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.orderStatus = order.getOrderStatus();
        this.userId = order.getClient().getId();
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

    public Long getUserId() {
        return this.userId;
    }

}
