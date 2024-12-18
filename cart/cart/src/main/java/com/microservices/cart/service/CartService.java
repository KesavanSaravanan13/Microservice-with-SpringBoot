package com.microservices.cart.service;


import com.microservices.cart.entity.Cart;
import com.microservices.cart.entity.Product;
import com.microservices.cart.entity.User;
import com.microservices.cart.feign.ProductFeignClient;
import com.microservices.cart.feign.UserFeign;
import com.microservices.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private CartRepository cartRepository;


    public List<Cart> getAllCart() {
        return this.cartRepository.findAll();
    }

    public void addProductToCart(Long userId, Long cartId, Long productId, Integer quantity) {
        Product product = productFeignClient.getProductById(productId);
        User user = userFeign.getUserById(userId);


        System.out.println(user);
        System.out.println(product);

    }

}
