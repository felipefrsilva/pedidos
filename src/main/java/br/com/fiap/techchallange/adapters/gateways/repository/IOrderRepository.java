package br.com.fiap.techchallange.adapters.gateways.repository;

import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.vo.Item;

import java.util.List;

public interface IOrderRepository {

    Order get(String id);
    void create(Order order);
    void update(Order order);
    public void updatePayment(Order order);
    void addItem(List<Item> items);
    Order getByOrderNumber(int number);
    List<Order> getOrders();
}
