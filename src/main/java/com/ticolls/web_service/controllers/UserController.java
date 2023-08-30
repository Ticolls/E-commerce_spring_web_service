package com.ticolls.web_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticolls.web_service.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1, "mario", "mario@gmail.com", "99999999", "12345");

        return ResponseEntity.ok().body(u);
    }
}
