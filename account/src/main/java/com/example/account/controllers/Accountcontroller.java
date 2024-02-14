package com.example.account.controllers;

import com.example.account.entities.Account;
import com.example.account.models.Customer;
import com.example.account.proxies.CustomerProxy;
import com.example.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Accountcontroller {
    AccountRepository accountRepository;
    CustomerProxy customerProxy;
    @Autowired
    public Accountcontroller(AccountRepository accountRepository, CustomerProxy customerProxy) {
        this.accountRepository = accountRepository;
        this.customerProxy = customerProxy;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts()
    {
        List<Account> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
            Customer customer = customerProxy.getCustomerById(account.getCustomerId());
            account.setCustomer(customer);
        });
        return accountList;
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable String id)
    {

        Account account = accountRepository.findById(id).orElse(null);
        if (account == null)
            return null;
        Customer customer = customerProxy.getCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
