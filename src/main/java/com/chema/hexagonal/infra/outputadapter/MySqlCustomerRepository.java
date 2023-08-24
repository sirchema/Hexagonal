package com.chema.hexagonal.infra.outputadapter;

import com.chema.hexagonal.domain.Customer;
import com.chema.hexagonal.infra.outputport.CustomerEntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlCustomerRepository implements CustomerEntityRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer c) {
        em.persist(c);

        return em.find(Customer.class, c.getId());

    }

    @Override
    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }
}
