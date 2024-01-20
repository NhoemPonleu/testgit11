package com.api.bank.account.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CustomerDTO {
    private String name;
    private String email;
    private String mobileNumber;
    private LocalDate createDate;
}
