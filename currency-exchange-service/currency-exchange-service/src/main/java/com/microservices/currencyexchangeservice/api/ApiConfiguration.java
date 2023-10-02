package com.microservices.currencyexchangeservice.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Value("${api.secretKey}")
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }
}
