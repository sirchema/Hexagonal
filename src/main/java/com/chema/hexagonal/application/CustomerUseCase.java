package com.chema.hexagonal.application;

import com.chema.hexagonal.domain.Customer;
import com.chema.hexagonal.infra.inputport.CustomerInputPort;
import com.chema.hexagonal.infra.outputport.CustomerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerUseCase implements CustomerInputPort {

    @Autowired
    CustomerEntityRepository entityRepository;

    @Override
    public Customer createCustomer(String name, String country) {
        Customer customer = Customer.builder()
                .name(name)
                .country(country)
                .build();
        return entityRepository.createCustomer(customer);
    }

    @Override
    public Customer getById(Long customerId) {
        return entityRepository.findById(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return entityRepository.findAll();
    }
}
