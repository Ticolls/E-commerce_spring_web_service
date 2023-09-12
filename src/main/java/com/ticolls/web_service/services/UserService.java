package com.ticolls.web_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ticolls.web_service.dtos.UserRequestDTO;
import com.ticolls.web_service.dtos.UserResponseDTO;
import com.ticolls.web_service.dtos.UserWithOrdersResponseDTO;
import com.ticolls.web_service.entities.User;
import com.ticolls.web_service.repositories.UserRepository;
import com.ticolls.web_service.services.exceptions.DatabaseException;
import com.ticolls.web_service.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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

        User user = optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));

        return new UserWithOrdersResponseDTO(user);
    }

    public UserResponseDTO save(UserRequestDTO newUserDTO) {

        User user = repository.save(new User(newUserDTO));

        return new UserResponseDTO(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserResponseDTO update(Long id, UserRequestDTO updateUser) {

        try {
        User user = repository.getReferenceById(id);

        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        user.setPhone(updateUser.getPhone());
        
        User updatedUser = repository.save(user);

        return new UserResponseDTO(updatedUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
        

    }

} 
 