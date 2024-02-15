package fr.mbds.customer.controllers;
import fr.mbds.customer.dtos.CustomerDTO;
import fr.mbds.customer.entities.Customer;
import fr.mbds.customer.repositories.CustomerRepository;
import fr.mbds.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/customers")
    public List<CustomerDTO> getCustomers() {
        return customerService.findAll();
    }


}
