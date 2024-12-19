package com.microservice_example.cart.service;

import com.microservice_example.cartItem.entity.Cart;
import com.microservice_example.cartItem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    public Cart updateCart(Long cartId, Cart updatedCart) {
        if (cartRepository.existsById(cartId)) {
            updatedCart.setCartId(cartId);
            return cartRepository.save(updatedCart);
        } else {
            throw new RuntimeException("Cart not found with id: " + cartId);
        }
    }

    public void deleteCart(Long cartId) {
        if (cartRepository.existsById(cartId)) {
            cartRepository.deleteById(cartId);
        } else {
            throw new RuntimeException("Cart not found with id: " + cartId);
        }
    }
}

