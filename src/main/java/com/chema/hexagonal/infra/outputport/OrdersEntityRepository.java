package com.chema.hexagonal.infra.outputport;

import com.chema.hexagonal.domain.Orders;

import java.util.List;

public interface OrdersEntityRepository {

    List<Orders> findAll();

    Orders createOrders(Orders c);

    Orders findById(Long id);
}
