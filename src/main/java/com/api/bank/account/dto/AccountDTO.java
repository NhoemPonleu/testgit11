package com.api.bank.account.dto;

import com.api.bank.account.model.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountDTO {
    private Long id;
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;
    private LocalDate createDate;
    private String customerName;
}
