package com.example.devops.services;
import com.example.devops.models.Account;
import com.example.devops.repositories.AccountRepository;
import com.example.devops.services.AccountServiceImpl;
import com.example.devops.services.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountServiceIntegrationTests {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testCalculateBalance() {
        // Save a sample account to the database
        Account testAccount = new Account("Test Account", 100.0, 50.0);
        accountRepository.save(testAccount);

        // Retrieve the account from the service and calculate balance
        Double balance = accountService.calculateBalance(testAccount.getId());

        // Verify the result
        assertEquals(50.0, balance, 0.01);
    }

    @Test
    public void testCalculateTotal() {
        // Save a sample account to the database
        Account testAccount = new Account("Test Account", 100.0, 50.0);
        accountRepository.save(testAccount);

        // Retrieve the account from the service and calculate total
        Double total = accountService.calculateTotal(testAccount.getId());

        // Verify the result
        assertEquals(50.0, total, 0.01);
    }

    // Additional tests for other service methods...
}
