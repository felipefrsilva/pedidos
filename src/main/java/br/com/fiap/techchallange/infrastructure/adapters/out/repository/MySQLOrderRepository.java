package br.com.fiap.techchallange.infrastructure.adapters.out.repository;

import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.domain.entity.Order;

public class MySQLOrderRepository implements IOrderRepository {
    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void update(Order order) {

    }
}
