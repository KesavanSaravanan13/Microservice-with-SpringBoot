package com.microservice_example.cart.feign;

import com.microservice_example.cart.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "${external.api.product-url}"
//        configuration = FeignConfig.class
)
public interface ProductFeignClient {

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable Long productId);
}
