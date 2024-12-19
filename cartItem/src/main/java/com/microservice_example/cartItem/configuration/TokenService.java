package com.microservice_example.cartItem.configuration;

import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TokenService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String getCurrentToken() throws JwtException {
        String token = retrieveTokenFromRequest();
        if (token == null || token.isEmpty()) {
            throw new JwtException("Token is missing");
        }

        if (jwtTokenProvider.isTokenExpired(token)) {
            throw new JwtException("Token is expired");
        }

        return token;
    }

    private String retrieveTokenFromRequest() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InRlc3RAZ21haWwuY29tIiwicm9sZSI6IkFkbWluIiwibmJmIjoxNzM0NTA3MDk2LCJleHAiOjE3MzQ1MTA2OTYsImlhdCI6MTczNDUwNzA5NiwiaXNzIjoieW91cklzc3VlciIsImF1ZCI6InlvdXJBdWRpZW5jZSJ9._p8x0Suv_nNu8r3I6Lpx2UMU2jWVsJC-wyx4wH-ILnA";
    }
}

