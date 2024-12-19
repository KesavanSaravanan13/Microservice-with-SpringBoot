package com.microservice_example.cartItem.service;


import com.microservice_example.cartItem.entity.CartItem;
import com.microservice_example.cartItem.entity.Product;
import com.microservice_example.cartItem.feign.ProductFeignClient;
import com.microservice_example.cartItem.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllCart() {
        return this.cartItemRepository.findAll();
    }

    public CartItem addProductToCart(Long userId, Long cartId, Long productId, Integer quantity) {
        Product product = productFeignClient.getProductById(productId);

        if (product == null) {
            throw new RuntimeException("Product with ID " + productId + " not found");
        }
        CartItem item = new CartItem();
        item.setCartId(cartId);
        item.setProductId(productId);
        item.setQuantity(quantity);
        item.setCreatedAt(LocalDateTime.now());

        return this.cartItemRepository.save(item);
    }

    public Optional<CartItem> getCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId);
    }

    public CartItem updateCartItem(Long cartItemId, CartItem updatedCartItem) {
        if (cartItemRepository.existsById(cartItemId)) {
            updatedCartItem.setCartItemId(cartItemId);
            return cartItemRepository.save(updatedCartItem);
        } else {
            throw new RuntimeException("CartItem not found with id: " + cartItemId);
        }
    }

    public void deleteCartItem(Long cartItemId) {
        if (cartItemRepository.existsById(cartItemId)) {
            cartItemRepository.deleteById(cartItemId);
        } else {
            throw new RuntimeException("CartItem not found with id: " + cartItemId);
        }
    }

}
