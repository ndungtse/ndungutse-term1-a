package com.example.devops.controllers;

import com.example.devops.dtos.CalcResponse;
import com.example.devops.dtos.DoMathRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDoMath() {
        DoMathRequest request = new DoMathRequest(10, 20, "+");
        ResponseEntity<CalcResponse> response = restTemplate.postForEntity("/math/doMath", request, CalcResponse.class);
        assertEquals(30, response.getBody().getResult(), 0.01);
    }

    @Test
    public void testAdd() {
        DoMathRequest request = new DoMathRequest(10, 20, "+");
        ResponseEntity<CalcResponse> response = restTemplate.postForEntity("/math/add", request, CalcResponse.class);
        assertEquals(30, response.getBody().getResult(), 0.01);
    }

    @Test
    public void testSubtract() {
        DoMathRequest request = new DoMathRequest(10, 20, "-");
        ResponseEntity<CalcResponse> response = restTemplate.postForEntity("/math/subtract", request, CalcResponse.class);
        assertEquals(-10, response.getBody().getResult(), 0.01);
    }

    @Test
    public void testMultiply() {
        DoMathRequest request = new DoMathRequest(10, 20, "*");
        ResponseEntity<CalcResponse> response = restTemplate.postForEntity("/math/multiply", request, CalcResponse.class);
        assertEquals(200, response.getBody().getResult(), 0.01);
    }

    @Test
    public void testDivide() {
        DoMathRequest request = new DoMathRequest(10, 20, "/");
        ResponseEntity<CalcResponse> response = restTemplate.postForEntity("/math/divide", request, CalcResponse.class);
        assertEquals(0.5, response.getBody().getResult(), 0.01);
    }

    @Test
    public void testDivideByZero() {
        DoMathRequest request = new DoMathRequest(10, 0, "/");
        ResponseEntity<CalcResponse> response = restTemplate.postForEntity("/math/divide", request, CalcResponse.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testUnknownOperation() {
        DoMathRequest request = new DoMathRequest(10, 20, "%");
        ResponseEntity<CalcResponse> response = restTemplate.postForEntity("/math/divide", request, CalcResponse.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
