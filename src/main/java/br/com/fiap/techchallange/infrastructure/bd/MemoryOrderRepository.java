package br.com.fiap.techchallange.infrastructure.bd;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;


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
    public Order get(String id) {
        return orders.get(id);
    }

    @Override
    public void create(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void update(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void updatePayment(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void addProduct(Order order, String sku, Integer qtd) {
        orders.put(order.getId(), order);
    }

    @Override
    public void removeProduct(Order order, String sku) {
        orders.put(order.getId(), order);
    }

    @Override
    public Order getByOrderNumber(int number) {
        return null;
    }

    @Override
    public void updateStatusByOrderNumber(int number, String status) {
        return null;
    }
}
