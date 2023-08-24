package com.chema.hexagonal.infra.inputport;

import com.chema.hexagonal.domain.Orders;

import java.math.BigDecimal;

public interface OrdersInputPort {

    public Orders createOrder(Long customerId, BigDecimal total);

}
