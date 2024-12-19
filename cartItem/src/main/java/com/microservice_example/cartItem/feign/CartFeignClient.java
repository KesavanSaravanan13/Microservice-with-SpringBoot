package com.microservice_example.cartItem.feign;

import com.microservice_example.cartItem.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("CART")
public interface CartFeignClient {

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts();

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id);
}
