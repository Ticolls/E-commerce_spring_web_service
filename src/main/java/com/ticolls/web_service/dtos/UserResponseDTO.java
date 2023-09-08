package com.ticolls.web_service.dtos;

import java.util.ArrayList;
import java.util.List;

import com.ticolls.web_service.entities.Order;
import com.ticolls.web_service.entities.User;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<OrderResponseDTO> orders = new ArrayList<>();

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.password = user.getPassword();
        
        for (Order order : user.getOrders()) {
            orders.add(new OrderResponseDTO(order));
        }

    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderResponseDTO> getOrders() {
        return this.orders;
    }

}
