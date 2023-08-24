package com.chema.hexagonal.infra.outputport;

import com.chema.hexagonal.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerEntityRepository {

    List<Customer> findAll();

    Customer createCustomer(Customer c);

    Customer findById(Long id);
}
