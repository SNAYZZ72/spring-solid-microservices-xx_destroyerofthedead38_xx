package com.example.account.proxies;

import com.example.account.models.Customer;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer", url = "http://localhost:8091/")
public interface CustomerProxy {
    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    List<Customer> getCustomers();

}
