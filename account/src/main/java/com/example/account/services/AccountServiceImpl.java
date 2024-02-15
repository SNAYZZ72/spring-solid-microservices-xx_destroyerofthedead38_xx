package com.example.account.services;

import com.example.account.dtos.AccountDTO;
import com.example.account.entities.Account;
import com.example.account.mappers.AccountMapper;
import com.example.account.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    AccountRepository accountRepository;

    AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll().stream().map(accountMapper::toDTO).toList();
    }

    @Override
    public AccountDTO findById(String id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null)
            return accountMapper.toDTO(account);
        return null;
    }
}
