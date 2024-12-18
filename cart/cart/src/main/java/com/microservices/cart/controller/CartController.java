package com.microservices.cart.controller;

import com.microservices.cart.entity.Cart;
import com.microservices.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCart() {
        List<Cart> cart = new ArrayList<>();
        cart = cartService.getAllCart();
        return ResponseEntity.ok(cart);
    }


}
