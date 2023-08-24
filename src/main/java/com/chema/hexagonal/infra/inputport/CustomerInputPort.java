package com.chema.hexagonal.infra.inputport;

import com.chema.hexagonal.domain.Customer;

import java.util.List;

public interface CustomerInputPort {

    public Customer createCustomer(String name, String country);

    public Customer getById(Long customerId);

    public List<Customer> getAll();
}
