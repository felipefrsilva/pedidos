package br.com.fiap.techchallange.core.usecase.orderpreparation;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpreparation.IFoodPreparationUseCase;
import br.com.fiap.techchallange.core.usecase.dto.order.EventOrder;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventTrigger;

public class FoodPreparationUseCase implements IFoodPreparationUseCase {

    private final IEventTrigger trigger;

    public FoodPreparationUseCase(IEventTrigger trigger) {
        this.trigger = trigger;
    }

    @Override
    public void invoke(int numberOrder) {
        this.trigger.event(new EventOrder(
                numberOrder
                , EventOrder.TypeEventOrder.PREPARATIONFOOD.getValue()
        ));
    }
}
