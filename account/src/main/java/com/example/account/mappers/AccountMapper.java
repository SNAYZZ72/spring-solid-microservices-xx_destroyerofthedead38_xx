package com.example.account.mappers;

import com.example.account.dtos.AccountDTO;
import com.example.account.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDTO toDTO(Account account) {
        return new AccountDTO(account.getId(), account.getBalance(), account.getDateCreated(), account.getCurrencyType(), account.getCustomerId(), account.getCustomer());
    }

    public Account toAccount(AccountDTO accountDTO) {
        return new Account(null, accountDTO.getBalance(), accountDTO.getDateCreated(), accountDTO.getCurrencyType(), accountDTO.getCustomerId(), accountDTO.getCustomer());
    }
}
