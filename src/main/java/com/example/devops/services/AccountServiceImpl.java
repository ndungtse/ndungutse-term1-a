package com.example.devops.services;

import com.example.devops.models.Account;
import com.example.devops.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        // Assuming the account with the given id already exists in the database
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Double calculateBalance(Integer id) {
        try {
            Optional<Account> account = accountRepository.findById(id);
            if (account.isPresent()) {
                return account.get().getDeposit() - account.get().getCredit();
            } else {
                throw new RuntimeException("Account not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error calculating balance", e);
        }
    }

    @Override
    public Double calculateTotal(Integer id) {
        try {
            Optional<Account> account = accountRepository.findById(id);
            if (account.isPresent()) {
                Double balance = account.get().getDeposit() - account.get().getCredit();
                return balance + (account.get().getTotal() != null ? account.get().getTotal() : 0.0);
            } else {
                throw new RuntimeException("Account not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error calculating total", e);
        }
    }

}
