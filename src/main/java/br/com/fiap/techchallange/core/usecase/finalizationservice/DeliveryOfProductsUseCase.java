package br.com.fiap.techchallange.core.usecase.finalizationservice;

import br.com.fiap.techchallange.core.usecase.dto.order.EventOrder;
import br.com.fiap.techchallange.core.usecase.inputboundary.finalizationservice.IDeliveryOfProductsUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventTrigger;

public class DeliveryOfProductsUseCase implements IDeliveryOfProductsUseCase {

    private final IEventTrigger trigger;

    public DeliveryOfProductsUseCase(IEventTrigger trigger) {
        this.trigger = trigger;
    }

    @Override
    public void invoke(int number_order) {
        this.trigger.event(new EventOrder(number_order, EventOrder.TypeEventOrder.DELIVERYFOOD.getValue()));
    }
}
