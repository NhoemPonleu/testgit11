package com.api.bank.account.controller;

import com.api.bank.account.dto.AccountDTO;
import com.api.bank.account.mapper.AccountMapper;
import com.api.bank.account.model.Account;
import com.api.bank.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/ac1count")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountDTO dto) {
        Account account = accountMapper.toAccount(dto);
        account = accountService.createAccount(account);
        return ResponseEntity.ok(accountMapper.toDto(account));

    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountService.findAllAccount();
        List<AccountDTO> accounts1 = accountMapper.toListDto(accounts);
        List<Long> ac = accounts1.stream().map(s -> s.getCustomerId()).collect(Collectors.toList());
        return ResponseEntity.ok(accounts1);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Account accounts1 = accountService.getById(id);
        AccountDTO accountDTO = accountMapper.toDto(accounts1);
        return ResponseEntity.ok(accountDTO);
    }
}
