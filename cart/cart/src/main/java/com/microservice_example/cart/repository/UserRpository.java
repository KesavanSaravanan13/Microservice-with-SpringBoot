package com.microservice_example.cart.repository;

import com.microservice_example.cart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRpository extends JpaRepository<User,Long> {
}
