package com.ticolls.web_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticolls.web_service.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}