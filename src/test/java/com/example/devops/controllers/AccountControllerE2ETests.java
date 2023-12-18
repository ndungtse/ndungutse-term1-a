package com.example.devops.controllers;
import com.example.devops.models.Account;
import com.example.devops.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerE2ETests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testGetAccountBalance() throws Exception {
        Account testAccount = new Account("Test Account", 100.0, 50.0);
        accountRepository.save(testAccount);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/{id}/balance", testAccount.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("50.0"));
    }

    @Test
    public void testGetAccountTotal() throws Exception {
        Account testAccount = new Account("Test Account", 100.0, 50.0);
        accountRepository.save(testAccount);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/{id}/total", testAccount.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("50.0"));
    }

}
