package com.microservice_example.cart.controller;

import com.microservice_example.cartItem.entity.CartItem;
import com.microservice_example.cartItem.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart-item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCart() {
        List<CartItem> item = new ArrayList<>();
        item = cartItemService.getAllCart();
        return ResponseEntity.ok(item);
    }

    @PostMapping("/{userId}/cart/{cartId}/product/{productId}/quantity/{quantity}")
    public CartItem addCartItem(@PathVariable Long userId, @PathVariable Long cartId, @PathVariable Long productId, @PathVariable Integer quantity) {
        return cartItemService.addProductToCart(userId, cartId, productId, quantity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
        Optional<CartItem> cartItem = cartItemService.getCartItemById(id);
        return cartItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem updatedCartItem) {
        try {
            CartItem cartItem = cartItemService.updateCartItem(id, updatedCartItem);
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        try {
            cartItemService.deleteCartItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
