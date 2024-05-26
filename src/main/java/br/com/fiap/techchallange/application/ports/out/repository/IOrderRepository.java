package br.com.fiap.techchallange.application.ports.out.repository;

import br.com.fiap.techchallange.domain.entity.Order;

public interface IOrderRepository {

    Order get(String id);
    void create(Order order);
    void update(Order order);
    void addProduct(Order order, String sku, Integer qtd);
    void updatePayment(Order order);
    void removeProduct(Order order, String sku);
}
