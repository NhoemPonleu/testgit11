package com.api.bank.account.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

//@Document(collation="customer")
@Entity
@Table(name = "customers1")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private LocalDate createDate;
}
