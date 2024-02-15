package com.example.account.controllers;

import com.example.account.dtos.AccountDTO;
import com.example.account.entities.Account;
import com.example.account.models.Customer;
import com.example.account.proxies.CustomerProxy;
import com.example.account.repositories.AccountRepository;
import com.example.account.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Accountcontroller {

    AccountService accountService;
    CustomerProxy customerProxy;
    @Autowired
    public Accountcontroller(AccountService accountService, CustomerProxy customerProxy) {
        this.accountService = accountService;
        this.customerProxy = customerProxy;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccounts()
    {
        List<AccountDTO> accountList = accountService.findAll();
        accountList.forEach(account -> {
            Customer customer = customerProxy.getCustomerById(account.getCustomerId());
            account.setCustomer(customer);
        });
        return accountList;
    }

    @GetMapping("/account/{id}")
    public AccountDTO getAccountById(@PathVariable String id)
    {

        AccountDTO accountDto = accountService.findById(id);
        if (accountDto == null)
            return null;
        Customer customer = customerProxy.getCustomerById(accountDto.getCustomerId());
        accountDto.setCustomer(customer);
        return accountDto;
    }
}
