package com.ticolls.web_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticolls.web_service.dtos.OrderResponseDTO;
import com.ticolls.web_service.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll() {

        List<OrderResponseDTO> orders = service.findAll();

        return ResponseEntity.ok().body(orders);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable Long id) {

        OrderResponseDTO order = service.findById(id);

        return ResponseEntity.ok().body(order);
    }
}
