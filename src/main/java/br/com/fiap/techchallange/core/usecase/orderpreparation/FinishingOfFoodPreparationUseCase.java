package br.com.fiap.techchallange.core.usecase.orderpreparation;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpreparation.IFinishingOfFoodPreparationUseCase;
import br.com.fiap.techchallange.core.usecase.dto.EventOrder;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventTrigger;

public class FinishingOfFoodPreparationUseCase implements IFinishingOfFoodPreparationUseCase {

    private final IEventTrigger trigger;

    public FinishingOfFoodPreparationUseCase(IEventTrigger trigger) {
        this.trigger = trigger;
    }

    public void invoke(int numberOrder) {
        this.trigger.event(new EventOrder(numberOrder, EventOrder.TypeEventOrder.FOODDONE.getValue()));
    }
}
