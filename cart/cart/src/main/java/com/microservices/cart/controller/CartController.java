package com.microservices.cart.controller;

import com.microservices.cart.entity.Cart;
import com.microservices.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart-item")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCart() {
        List<Cart> cart = new ArrayList<>();
        cart = cartService.getAllCart();
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{userId}/cart-id={cartId}/{productId}quantity={quantity}")
    public void addCartItem(@PathVariable Long userId, @PathVariable Long cartId, @PathVariable Long productId, @PathVariable Integer quantity) {
        cartService.addProductToCart(userId, cartId, productId, quantity);
    }


}
