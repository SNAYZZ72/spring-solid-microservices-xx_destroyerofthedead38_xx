package fr.mbds.customer;

import fr.mbds.customer.entities.Customer;
import fr.mbds.customer.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

        @Bean
        CommandLineRunner commandLineRunner(CustomerRepository customerRepository)
        {
            return args -> {
            Customer customer1 = Customer.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@gmail.com")
                    .build();
            customerRepository.save(customer1);
            Customer customer2 = Customer.builder()
                    .firstName("Bob")
                    .lastName("Dylan")
                    .email("bob.dylan@gmail.com")
                    .build();
            customerRepository.save(customer2);
            Customer customer3 = Customer.builder()
                    .firstName("Alice")
                    .lastName("Cooper")
                    .email("alice.cooper@gmail.com")
                    .build();
            customerRepository.save(customer3);
        };
    }
}
