package com.ticolls.web_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticolls.web_service.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}