package com.example.devops.controllers;

import com.example.devops.dtos.CalcResponse;
import com.example.devops.dtos.DoMathRequest;
import com.example.devops.exceptions.DivisionByZeroException;
import com.example.devops.exceptions.InvalidOperationException;
import com.example.devops.services.MathOperatorImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class MathControllerE2ETests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathOperatorImpl mathOperator;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testDoMathEndpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(3.0, 4.0, "+");
        CalcResponse response = new CalcResponse(7.0);

        when(mathOperator.doMath(3.0, 4.0, "+")).thenReturn(7.0);

        mockMvc.perform(MockMvcRequestBuilders.post("/math/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.result").value(7.0));
    }

    @Test
    void testAddEndpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(3.0, 4.0, "+");
        CalcResponse response = new CalcResponse(7.0);

        when(mathOperator.doMath(3.0, 4.0, "+")).thenReturn(7.0);

        mockMvc.perform(MockMvcRequestBuilders.post("/math/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.result").value(7.0));
    }

    @Test
    void testSubtractEndpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(3.0, 4.0, "-");
        CalcResponse response = new CalcResponse(-1.0);

        when(mathOperator.doMath(3.0, 4.0, "-")).thenReturn(-1.0);

        mockMvc.perform(MockMvcRequestBuilders.post("/math/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.result").value(-1.0));
    }

    @Test
    void testMultiplyEndpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(3.0, 4.0, "*");
        CalcResponse response = new CalcResponse(12.0);

        when(mathOperator.doMath(3.0, 4.0, "*")).thenReturn(12.0);

        mockMvc.perform(MockMvcRequestBuilders.post("/math/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.result").value(12.0));
    }

    @Test
    void testDivideEndpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(3.0, 4.0, "/");
        CalcResponse response = new CalcResponse(0.75);

        when(mathOperator.doMath(3.0, 4.0, "/")).thenReturn(0.75);

        mockMvc.perform(MockMvcRequestBuilders.post("/math/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.result").value(0.75));
    }

    @Test
    void testDivideByZeroEndpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(3.0, 0.0, "/");

        when(mathOperator.doMath(3.0, 0.0, "/")).thenThrow(new InvalidOperationException("Cannot divide by zero"));

        mockMvc.perform(MockMvcRequestBuilders.post("/math/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void testUnknownOperationEndpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(3.0, 4.0, "%");

        when(mathOperator.doMath(3.0, 4.0, "%")).thenThrow(new InvalidOperationException("Unknown operation"));

        mockMvc.perform(MockMvcRequestBuilders.post("/math/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
