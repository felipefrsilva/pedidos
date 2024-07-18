package br.com.fiap.techchallange.core.usecase.tracking;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.enums.StatusOrder;

public class OrderUpdateStatusUseCase implements IEventListenerOrder {

    private final IOrderRepository orderRepository;

    public OrderUpdateStatusUseCase(IOrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void onEvent(EventOrder eventOrder) {
        StatusOrder status = getStatus(eventOrder.process());
        Order order = this.orderRepository.getByOrderNumber(eventOrder.number_order());
        order.updateStatus(status);
        this.orderRepository.update(order);
    }

    private StatusOrder getStatus(String eventProcessing){

        StatusOrder status;

        switch (eventProcessing){
            case "payment" : status = StatusOrder.RECEIVED; break;
            case "preparationFood" : status = StatusOrder.INPREPARATION; break;
            case "foodDone" : status = StatusOrder.FOODDONE; break;
            case "deliveryFood" : status = StatusOrder.FINISHED; break;
            default:
                throw new RuntimeException("Event don't mapped");
        }

        return status;
    }
}
