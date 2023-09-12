package com.ticolls.web_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticolls.web_service.dtos.UserRequestDTO;
import com.ticolls.web_service.dtos.UserResponseDTO;
import com.ticolls.web_service.dtos.UserWithOrdersResponseDTO;
import com.ticolls.web_service.entities.User;
import com.ticolls.web_service.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> findAll() {
        List<User> users = repository.findAll();

        List<UserResponseDTO> usersDTO = new ArrayList<>();

        for (User user : users) {
            usersDTO.add(new UserResponseDTO(user));
        }

        return usersDTO;
    }

    public UserWithOrdersResponseDTO findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);

        return new UserWithOrdersResponseDTO(optionalUser.get());
    }

    public UserResponseDTO save(UserRequestDTO newUserDTO) {

        User user = repository.save(new User(newUserDTO));

        return new UserResponseDTO(user);
    }
} 
 