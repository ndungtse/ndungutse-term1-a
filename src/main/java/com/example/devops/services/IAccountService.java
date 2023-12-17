package com.example.devops.services;

import com.example.devops.models.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Optional<Account> getAccountById(Integer id);

    List<Account> getAllAccounts();

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);
    Double calculateBalance(Integer id);

    Double calculateTotal(Integer id);
}
