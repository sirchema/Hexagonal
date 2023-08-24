package com.chema.hexagonal.infra.inputAdapter;

import com.chema.hexagonal.domain.Customer;
import com.chema.hexagonal.infra.inputport.CustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customer")
public class CustomerAPI {

    @Autowired
    CustomerInputPort customerInputPort;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer create(@RequestParam String name, @RequestParam String country) {
        return customerInputPort.createCustomer(name, country);
    }

    @PostMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer get(@RequestParam Long customerId) {
        return customerInputPort.getById(customerId);
    }

    @GetMapping(value = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAll() {
        return customerInputPort.getAll();
    }

}
