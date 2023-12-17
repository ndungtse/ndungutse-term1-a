package com.example.devops.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Transient
    private Double balance;
    private Double deposit;
    private Double credit;

    @Transient
    private Double total;

    public Account(String name, Double deposit, Double credit) {
        this.name = name;
        this.deposit = deposit;
        this.credit = credit;
    }
}
