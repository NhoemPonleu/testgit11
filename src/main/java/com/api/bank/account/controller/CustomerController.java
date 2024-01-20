package com.api.bank.account.controller;

import com.api.bank.account.dto.CustomerDTO;
import com.api.bank.account.mapper.CustomerMapper;
import com.api.bank.account.model.Customer;
import com.api.bank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
        customer = customerService.create(customer);
        return ResponseEntity.ok(customer);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable("id") Long customerID) {
        Customer customer = customerService.getById(customerID);
        return ResponseEntity.ok(customer);
    }
    @GetMapping
    public ResponseEntity<?> findCustomerById() {
        List<Customer> customer = customerService.getAll();
        return ResponseEntity.ok(customer);
    }
}
