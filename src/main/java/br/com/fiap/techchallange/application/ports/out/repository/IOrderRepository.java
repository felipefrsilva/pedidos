package br.com.fiap.techchallange.application.ports.out.repository;

import br.com.fiap.techchallange.domain.entity.Order;

public interface IOrderRepository {

    Order getOrder(String id);
    void addOrder(Order order);
    void update(Order order);
}
