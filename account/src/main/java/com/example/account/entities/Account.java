package com.example.account.entities;

import com.example.account.enums.CurrencyType;
import com.example.account.models.Customer;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Currency;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Account {
    @Id
    private String id;

    private Double balance;
    private LocalDate dateCreated;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    private Long customerId;
    @Transient
    private Customer customer;


}
