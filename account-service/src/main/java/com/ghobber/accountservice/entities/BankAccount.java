package com.ghobber.accountservice.entities;

import com.ghobber.accountservice.enums.AccountType;
import com.ghobber.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;//solde
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient//pour indiquer que cet attribut va etre ignrer au niveau de ma base
    private Customer customer; // une classe customer dans un package model qui n'est pas une entité
    private Long customerId;
}
