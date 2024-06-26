package br.com.fiap.techchallange.application.usecases;

import br.com.fiap.techchallange.application.dto.TrackerOrderDTO;
import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.domain.entity.Order;
import br.com.fiap.techchallange.domain.enums.StatusOrder;

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
