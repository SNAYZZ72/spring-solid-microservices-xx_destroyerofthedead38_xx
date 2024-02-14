package com.example.account;

import com.example.account.entities.Account;
import com.example.account.enums.CurrencyType;
import com.example.account.models.Customer;
import com.example.account.proxies.CustomerProxy;
import com.example.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@EnableFeignClients
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerProxy customerProxy) {
		return args -> {
			List<Customer> customerList = customerProxy.getCustomers();
			customerList.forEach(customer -> {
				Account account = Account.builder()
						.id(UUID.randomUUID().toString())
						.balance(1000 * Math.random())
						.dateCreated(LocalDate.now())
						.currencyType(CurrencyType.EUR)
						.customerId(customer.getId())
						.build();
				accountRepository.save(account);

			});
		};
	}
}
