package br.com.fiap.techchallange.infrastructure.bd.mock;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.vo.Item;


import java.util.HashMap;
import java.util.List;
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
    public void addItem(List<Item> items) {

    }

    @Override
    public Order getByOrderNumber(int number) {
        return new Order("1245658554785");
    }

    @Override
    public List<Order> getOrders() {
        return List.of();
    }
}
