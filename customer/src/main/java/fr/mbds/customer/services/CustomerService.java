package fr.mbds.customer.services;

import fr.mbds.customer.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);
}
