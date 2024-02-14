package com.example.account;

import com.example.account.entities.Account;
import com.example.account.enums.CurrencyType;
import com.example.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;
@EnableFeignClients
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
		return args -> {
			Account account1 = Account.builder()
					.id(UUID.randomUUID().toString())
					.balance(1000D)
					.dateCreated(LocalDate.now())
					.customerId(1L)
					.currencyType(CurrencyType.EUR)
					.build();
			accountRepository.save(account1);
			Account account2 = Account.builder()
					.id(UUID.randomUUID().toString())
					.balance(200000D)
					.dateCreated(LocalDate.now())
					.customerId(2L)
					.currencyType(CurrencyType.USD)
					.build();
			accountRepository.save(account2);


		};
	}

}
