package com.example.devops.services;

import com.example.devops.models.Account;
import com.example.devops.repositories.AccountRepository;
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
        Account mockAccount = new Account("Test Account", 100.0, 50.0);
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(mockAccount));

        Double balance = accountService.calculateBalance(1);

        assertEquals(50.0, balance, 0.01);
    }

    @Test
    public void testCalculateBalanceAccountNotFound() {
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> accountService.calculateBalance(1));
    }

    @Test
    public void testCalculateTotal() {
        // Mocking the account
        Account mockAccount = new Account("Test Account", 100.0, 50.0);
        Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(mockAccount));

        Double total = accountService.calculateTotal(1);
        assertEquals(50.0, total, 0.01);
    }
}
