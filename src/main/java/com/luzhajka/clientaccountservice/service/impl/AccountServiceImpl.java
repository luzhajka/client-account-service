package com.luzhajka.clientaccountservice.service.impl;

import com.luzhajka.clientaccountservice.repository.AccountRepository;
import com.luzhajka.clientaccountservice.repository.entity.AccountEntity;
import com.luzhajka.clientaccountservice.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public UUID createAccountService(Long clientId) {
        return accountRepository
                .saveAndFlush(new AccountEntity(clientId))
                .getAccountNumber();
    }
}
