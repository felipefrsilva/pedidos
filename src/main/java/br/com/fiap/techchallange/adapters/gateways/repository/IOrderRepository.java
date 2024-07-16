package br.com.fiap.techchallange.adapters.gateways.repository;

import br.com.fiap.techchallange.core.entity.Order;

public interface IOrderRepository {

    Order get(String id);
    void create(Order order);
    void update(Order order);
    void updatePayment(Order order);
    void addProduct(Order order, String sku, Integer qtd);
    void removeProduct(Order order, String sku);
}
