package com.microservice_example.cart.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String role;
    private String email;
    private String address;
    private String postalCode;
    private String country;
    private String phone;


    @Override
    public String toString() {
        return "User{" +
                "customerId=" + userId +
                ", customerName='" + username + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
