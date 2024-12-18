package com.microservices.cart.feign;

import com.microservices.cart.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", url = "${user.service.url}"
//        configuration = FeignConfig.class
)
public interface UserFeign {
    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable Long userId);
}