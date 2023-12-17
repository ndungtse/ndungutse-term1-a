package com.example.devops.services;

import com.example.devops.models.Account;
import com.example.devops.repositories.AccountRepository;
import com.example.devops.services.AccountServiceImpl;
import com.example.devops.services.IAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private IAccountService accountService = new AccountServiceImpl(accountRepository);

    @Test
    public void testCalculateBalance() {
        // Mocking the account
        Account mockAccount = new Account("Test Account", 100.0, 50.0);
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(mockAccount));

        // Calling the service method
        Double balance = accountService.calculateBalance(1);

        // Verifying the result
        assertEquals(50.0, balance, 0.01); // Using a delta to account for potential floating-point precision issues
    }

    @Test
    public void testCalculateBalanceAccountNotFound() {
        // Mocking the account repository to return an empty Optional
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.empty());

        // Verifying that the service method throws the expected exception
        assertThrows(RuntimeException.class, () -> accountService.calculateBalance(1));
    }

    @Test
    public void testCalculateTotal() {
        // Mocking the account
        Account mockAccount = new Account("Test Account", 100.0, 50.0);
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(mockAccount));

        // Calling the service method
        Double total = accountService.calculateTotal(1);

        // Verifying the result
        assertEquals(50.0, total, 0.01); // Using a delta to account for potential floating-point precision issues
    }

    // Similar tests for other scenarios...
}
