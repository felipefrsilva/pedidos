package br.com.fiap.techchallange.infrastructure.ports.out.repository;

import br.com.fiap.techchallange.orders.domain.entity.Order;

public interface IOrderRepository {

    public Order getOrder(String id);
    public void addOrder(Order order);
}
