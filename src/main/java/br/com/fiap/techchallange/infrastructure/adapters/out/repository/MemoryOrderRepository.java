package br.com.fiap.techchallange.infrastructure.adapters.out.repository;

import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.domain.entity.Order;

import java.util.HashMap;
import java.util.Map;

public class MemoryOrderRepository implements IOrderRepository {

    private static MemoryOrderRepository instance;
    private final Map<String, Order> orders;

    public MemoryOrderRepository(){
        orders = new HashMap<>();
    }

    public static synchronized MemoryOrderRepository getInstance() {
        if (instance == null) {
            instance = new MemoryOrderRepository();
        }
        return instance;
    }

    public synchronized Map<String, Order> getDatabase() {
        return orders;
    }

    @Override
    public Order getOrder(String id) {
        return orders.get(id);
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void update(Order order) {
        orders.put(order.getId(), order);
    }
}
