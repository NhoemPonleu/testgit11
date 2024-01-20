package com.api.bank.account.service.impl;

import com.api.bank.account.exception.ResourceNotFoundException;
import com.api.bank.account.model.Customer;
import com.api.bank.account.repository.CustomerRepository;
import com.api.bank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow
                        (()->new ResourceNotFoundException("Customer",customerId));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
