package com.microservices.cart.feign;

import com.microservices.cart.configuration.FeignConfig;
import com.microservices.cart.entity.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "${external.api.product-url}", configuration = FeignConfig.class)
public interface ProductFeignClient {

    @GetMapping("/products/{productId}")
    Product getProductById(@PathVariable("productId") Long productId);
}
