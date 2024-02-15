package com.example.account.dtos;

import com.example.account.enums.CurrencyType;
import com.example.account.models.Customer;
import lombok.*;

import java.time.LocalDate;

@Data @Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class AccountDTO {
    private String id;
    private Double balance;
    private LocalDate dateCreated;
    private CurrencyType currencyType;
    private Long customerId;
    private Customer customer;
}
