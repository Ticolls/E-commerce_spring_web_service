package com.ticolls.web_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticolls.web_service.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
