package com.ticolls.web_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticolls.web_service.dtos.UserResponseDTO;
import com.ticolls.web_service.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {

        List<UserResponseDTO> users = service.findAll();

        return ResponseEntity.ok().body(users);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {

        UserResponseDTO user = service.findById(id);

        return ResponseEntity.ok().body(user);

    }
}
