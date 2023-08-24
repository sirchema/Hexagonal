package com.chema.hexagonal.application;

import com.chema.hexagonal.domain.Orders;
import com.chema.hexagonal.infra.inputport.OrdersInputPort;
import com.chema.hexagonal.infra.outputport.CustomerEntityRepository;
import com.chema.hexagonal.infra.outputport.OrdersEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class OrdersUseCase implements OrdersInputPort {

    @Autowired
    OrdersEntityRepository entityRepository;

    @Override
    public Orders createOrder(Long customerId, BigDecimal total) {
        Orders order = Orders.builder()
                .customerId(customerId)
                .total(total)
                .build();
        return entityRepository.createOrders(order);
    }
}
