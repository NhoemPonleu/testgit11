package com.api.bank.account.mapper;

import com.api.bank.account.dto.CustomerDTO;
import com.api.bank.account.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerDTO customerDTO){
        Customer customer=new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        customer.setCreateDate(LocalDate.now());
        return customer;

    }
}
