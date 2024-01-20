package com.api.bank.account.service;

import com.api.bank.account.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer create(Customer customer);

    Customer getById(Long customerId);
    List<Customer> getAll();
}
