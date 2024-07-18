package br.com.fiap.techchallange.adapters.controllers.orderpreparation;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpreparation.IFinishingOfFoodPreparationUseCase;

public class FinishingOfFoodPreparationController implements IFinishingOfFoodPreparationController {

    private final IFinishingOfFoodPreparationUseCase finishingOfFoodPreparation;

    public FinishingOfFoodPreparationController(IFinishingOfFoodPreparationUseCase finishingOfFoodPreparation){
        this.finishingOfFoodPreparation = finishingOfFoodPreparation;
    }

    @Override
    public void invoke(int numberOrder) {
        finishingOfFoodPreparation.invoke(numberOrder);
    }
}
