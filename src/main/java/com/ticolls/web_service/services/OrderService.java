package com.ticolls.web_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticolls.web_service.dtos.OrderResponseDTO;
import com.ticolls.web_service.entities.Order;
import com.ticolls.web_service.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    public List<OrderResponseDTO> findAll() {
        List<Order> orders = repository.findAll();

        List<OrderResponseDTO> ordesDTO = new ArrayList<>();

        for (Order order : orders) {
            ordesDTO.add(new OrderResponseDTO(order));
        }

        return ordesDTO;
    }

    public OrderResponseDTO findById(Long id) {
        Optional<Order> optionalOrder = repository.findById(id);

        return new OrderResponseDTO(optionalOrder.get());
    }
} 
 