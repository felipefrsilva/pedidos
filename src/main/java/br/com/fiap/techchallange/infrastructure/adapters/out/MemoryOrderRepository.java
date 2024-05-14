package br.com.fiap.techchallange.infrastructure.adapters.out;

import br.com.fiap.techchallange.infrastructure.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.orders.domain.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class MemoryOrderRepository implements IOrderRepository {

    List<Order> orders;

    public MemoryOrderRepository(){
        orders = new ArrayList<Order>();
    }

    @Override
    public Order getOrder(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }
}
