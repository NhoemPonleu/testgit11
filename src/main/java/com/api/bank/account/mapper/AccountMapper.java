package com.api.bank.account.mapper;

import com.api.bank.account.dto.AccountDTO;
import com.api.bank.account.model.Account;
import com.api.bank.account.model.Customer;
import com.api.bank.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {
    @Autowired
    private CustomerService customerService;
    public Account toAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountType(accountDTO.getAccountType());
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBranchAddress(accountDTO.getBranchAddress());
        account.setCreateDate(LocalDate.now());
        account.setCustomer(customerService.getById(accountDTO.getCustomerId()));
        System.out.println("Ucstomer Id"+account.getCustomer().getCustomerId());
        return account;

    }
    public AccountDTO toDto(Account account){
        AccountDTO accountDTO=new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setCustomerId(account.getCustomer().getCustomerId());
        accountDTO.setBranchAddress(account.getBranchAddress());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setCreateDate(LocalDate.now());
        accountDTO.setCustomerName(account.getCustomer().getName());
        return accountDTO;
    }
    public List<AccountDTO> toListDto(List<Account> toAccounts) {
        List<AccountDTO> accountDTOList = new ArrayList<>();

        for (Account account : toAccounts) {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(account.getId());
            accountDTO.setAccountNumber(account.getAccountNumber());
            accountDTO.setCustomerId(account.getCustomer().getCustomerId());
            accountDTO.setBranchAddress(account.getBranchAddress());
            accountDTO.setAccountType(account.getAccountType());
            accountDTO.setCreateDate(LocalDate.now());

            accountDTOList.add(accountDTO);
        }

        return accountDTOList;
    }
}
