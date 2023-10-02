package com.microservices.currencyexchangeservice.api;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    private final ApiConfiguration apiConfig;

    public ApiService(ApiConfiguration apiConfig) {
        this.apiConfig = apiConfig;
    }

    public String connectToApi() {
        String secretKey = apiConfig.getSecretKey();
        String apiUrl = "http://data.fixer.io/api/latest";
        String symbols = "USD,KZT";
        String url = apiUrl + "?access_key=" + secretKey + "&symbols=" + symbols + "&format=1";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();

    }
}
