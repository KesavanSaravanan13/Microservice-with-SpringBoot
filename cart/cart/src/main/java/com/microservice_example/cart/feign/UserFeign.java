package com.microservice_example.cart.feign;

import com.microservice_example.cartItem.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", url = "${external.api.user-url}"
//        configuration = FeignConfig.class
)
public interface UserFeign {
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId);
}