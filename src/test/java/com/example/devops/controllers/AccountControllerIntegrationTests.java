package com.example.devops.controllers;

import com.example.devops.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerIntegrationTests {

//    @LocalServerPort
//    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAccountBalance() {
//        String baseUrl = "http://localhost:" + port + "/api/accounts/1/balance"; /

        ResponseEntity<Double> response = restTemplate.getForEntity("/api/accounts/1/balance", Double.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(50.0, response.getBody(), 0.01); // Replace with the expected balance
    }

}
