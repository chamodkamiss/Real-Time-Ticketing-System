package org.example.cli;

import org.springframework.web.client.RestTemplate;

public class ApiClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;


    public ApiClient(String baseUrl) {
        this.restTemplate = new RestTemplate();
        this.baseUrl = baseUrl;
    }

    public void startVendor() {

    }
}
