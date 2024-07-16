package br.com.fiap.techchallange.core.usecase;

import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.infrastructure.dto.TrackerOrderDTO;
import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.enums.StatusOrder;

public class TrackerOrderApplication {

    private final IOrderRepository repositoryOrder;

    public TrackerOrderApplication(IOrderRepository repositoryOrder){
        this.repositoryOrder = repositoryOrder;
    }

    public void prepareFood(String orderId) {
        Order order = repositoryOrder.get(orderId);
        order.updateStatus(StatusOrder.INPREPARATION);
        repositoryOrder.update(order);
    }

    public void finishPreparation(String orderId) {
        Order order = repositoryOrder.get(orderId);
        order.updateStatus(StatusOrder.READY);
        repositoryOrder.update(order);
    }

    public void deliverFood(String orderId) {
        Order order = repositoryOrder.get(orderId);
        order.updateStatus(StatusOrder.FINISHED);
        repositoryOrder.update(order);
    }

    public TrackerOrderDTO getTracker(String orderId) {
        Order order = repositoryOrder.get(orderId);
        return new TrackerOrderDTO(order.getId(),
                                   order.getNumberOrder(),
                                   order.getItems(),
                                   order.getStatus());
    }
}
