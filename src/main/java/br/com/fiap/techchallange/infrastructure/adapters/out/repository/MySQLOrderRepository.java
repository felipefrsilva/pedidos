package br.com.fiap.techchallange.infrastructure.adapters.out.repository;

import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.domain.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MySQLOrderRepository implements IOrderRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Order getOrder(String id) {
        return entityManager.find(Order.class, id);
    }

    @Transactional
    @Override
    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }
}
