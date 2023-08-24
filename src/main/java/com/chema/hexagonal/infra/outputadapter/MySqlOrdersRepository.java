package com.chema.hexagonal.infra.outputadapter;

import com.chema.hexagonal.domain.Customer;
import com.chema.hexagonal.domain.Orders;
import com.chema.hexagonal.infra.outputport.CustomerEntityRepository;
import com.chema.hexagonal.infra.outputport.OrdersEntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlOrdersRepository implements OrdersEntityRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Orders> findAll() {
        return em.createQuery("select o from Orders o", Orders.class).getResultList();
    }

    @Override
    public Orders createOrders(Orders o) {
        em.persist(o);

        return em.find(Orders.class, o.getId());

    }

    @Override
    public Orders findById(Long id) {
        return em.find(Orders.class, id);
    }
}
