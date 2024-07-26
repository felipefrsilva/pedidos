package br.com.fiap.techchallange.core.usecase.tracking;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.enums.StatusOrder;
import br.com.fiap.techchallange.core.usecase.dto.order.EventOrder;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventListenerOrder;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.tracking.IDisplayInformationOrderPresenter;

public class OrderUpdateStatusUseCase implements IEventListenerOrder {

    private final IOrderRepository orderRepository;
    private final IDisplayInformationOrderPresenter displayInformationOrderPresenter;



    public OrderUpdateStatusUseCase(IOrderRepository orderRepository,
                                    IDisplayInformationOrderPresenter displayInformationOrderPresenter){
        this.orderRepository = orderRepository;
        this.displayInformationOrderPresenter = displayInformationOrderPresenter;
    }

    @Override
    public void onEvent(EventOrder eventOrder) {
        StatusOrder status = getStatus(eventOrder.process());
        Order order;
        if (eventOrder.idOrder() != null) {
            // Quando o idOrder é diferente de null, significa que o evento foi disparado pelo serviço de pagamento
           order = this.orderRepository.get(eventOrder.idOrder());
        } else {
            // Quando o idOrder é igual a null, significa que o evento foi disparado pelos serviços posteriores ao pagamento
           order = this.orderRepository.getByOrderNumber(eventOrder.number_order());
        }
        order.updateStatus(status);
        this.orderRepository.update(order);
        displayInformationOrderPresenter.display(new OutputDataOrderDTO(order.getId(),
                                                                        order.getNumberOrder(),
                                                                        order.getStatus()));
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
