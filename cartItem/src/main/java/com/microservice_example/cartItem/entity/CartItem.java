package com.microservice_example.cartItem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CartItem {
    @Id
    @GeneratedValue()
    private Long cartItemId;
    private LocalDateTime createdAt;

    @Column
    private Long productId;

    private Long cartId;

    private int quantity;

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long product) {
        this.productId = product;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}