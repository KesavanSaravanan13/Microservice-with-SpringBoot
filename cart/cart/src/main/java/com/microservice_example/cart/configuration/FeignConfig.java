package com.microservice_example.cart.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Autowired
    private TokenService tokenService;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                try {
                    String token = tokenService.getCurrentToken();
                    template.header("Authorization", "Bearer " + token);
                } catch (JwtException e) {

                }
            }
        };
    }
}


