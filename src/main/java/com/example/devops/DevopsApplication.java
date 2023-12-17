package com.example.devops;

import com.example.devops.models.Account;
import com.example.devops.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DevopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevopsApplication.class, args);
    }
    @Bean
    public CommandLineRunner dataSeeder(AccountRepository accountRepository) {
        return args -> {
            // Check if data already exists
            List<Account> existingAccounts = accountRepository.findAll();

            if (existingAccounts.isEmpty()) {
                // Seed data if it doesn't exist
                Account account1 = new Account("Account 1", 100.0, 50.0);
                Account account2 = new Account("Account 2", 200.0, 30.0);

                accountRepository.saveAll(List.of(account1, account2));

                System.out.println("Seed data has been inserted.");
            } else {
                System.out.println("Data already exists. Skipping seeding.");
            }
        };
    }
}
