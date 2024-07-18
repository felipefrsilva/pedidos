package br.com.fiap.techchallange.core.usecase.tracking;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.enums.StatusOrder;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IOrderUpdateStatusUseCase;

public class OrderUpdateStatusUseCase implements IOrderUpdateStatusUseCase {

    private final IOrderRepository orderRepository;

    public OrderUpdateStatusUseCase(IOrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void invoke(int number, String eventProcessing) {
        String status = getStatus(eventProcessing);
        this.orderRepository.updateStatusByOrderNumber(number, status);
    }

    private String getStatus(String eventProcessing){

        String status = "";

        switch (eventProcessing){
            case "payment" : status = StatusOrder.RECEIVED.getValue(); break;
            case "preparationFood" : status = StatusOrder.INPREPARATION.getValue(); break;
            case "foodDone" : status = StatusOrder.FOODDONE.getValue(); break;
            case "deliveryFood" : status = StatusOrder.FINISHED.getValue(); break;
            default:
                throw new RuntimeException("Event dont mapped");
        }

        return status;
    }


}
