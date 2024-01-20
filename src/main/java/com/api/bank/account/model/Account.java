package com.api.bank.account.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

//@Document(collation = "accounts")
@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    private String accountType;
    private String branchAddress;
    private LocalDate createDate;
}
