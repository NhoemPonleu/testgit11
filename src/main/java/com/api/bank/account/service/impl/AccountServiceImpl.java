package com.api.bank.account.service.impl;

import com.api.bank.account.exception.ResourceNotFoundException;
import com.api.bank.account.model.Account;
import com.api.bank.account.repository.AccountRepository;
import com.api.bank.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(()->new ResourceNotFoundException("Account",accountId));
    }
}
