package com.ticolls.web_service.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ticolls.web_service.dtos.UserRequestDTO;
import com.ticolls.web_service.dtos.UserResponseDTO;
import com.ticolls.web_service.dtos.UserWithOrdersResponseDTO;
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
    public ResponseEntity<UserWithOrdersResponseDTO> findById(@PathVariable Long id) {

        UserWithOrdersResponseDTO user = service.findById(id);

        return ResponseEntity.ok().body(user);

    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO newUser) {
        
        UserResponseDTO user = service.save(newUser);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO updateUser) {

        UserResponseDTO updatedUser = service.update(id, updateUser);

        return ResponseEntity.ok().body(updatedUser);
    }
}
