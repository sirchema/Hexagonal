package com.chema.hexagonal.infra.inputAdapter;

import com.chema.hexagonal.domain.Orders;
import com.chema.hexagonal.infra.inputport.OrdersInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "order")
public class OrdersAPI {

    @Autowired
    OrdersInputPort ordersInputPort;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders create(@RequestParam Long customerId, @RequestParam BigDecimal total) {
        return ordersInputPort.createOrder(customerId, total);
    }
}
