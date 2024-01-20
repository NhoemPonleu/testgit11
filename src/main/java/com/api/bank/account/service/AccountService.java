package com.api.bank.account.service;

import com.api.bank.account.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account>findAllAccount();
    Account getById(Long accountId);
}
