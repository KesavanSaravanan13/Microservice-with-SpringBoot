package com.microservice_example.cart.service;


import com.microservice_example.cart.entity.Cart;
import com.microservice_example.cart.entity.Product;
import com.microservice_example.cart.entity.User;
import com.microservice_example.cart.feign.ProductFeignClient;
import com.microservice_example.cart.feign.UserFeign;
import com.microservice_example.cart.repository.CartRepository;
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

    public User addProductToCart(Long userId, Long cartId, Long productId, Integer quantity) {
        Product product = productFeignClient.getProductById(productId);
        User user = userFeign.getUserById(userId);

        System.out.println(user);
        System.out.println(product);
        return user;
    }

}
