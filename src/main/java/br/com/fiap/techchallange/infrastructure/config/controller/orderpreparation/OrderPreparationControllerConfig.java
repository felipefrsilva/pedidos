package br.com.fiap.techchallange.infrastructure.config.controller.orderpreparation;

import br.com.fiap.techchallange.adapters.controllers.orderpreparation.FinishingOfFoodPreparationController;
import br.com.fiap.techchallange.adapters.controllers.orderpreparation.FoodPreparationController;
import br.com.fiap.techchallange.adapters.controllers.orderpreparation.IFinishingOfFoodPreparationController;
import br.com.fiap.techchallange.adapters.controllers.orderpreparation.IFoodPreparationController;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpreparation.IFinishingOfFoodPreparationUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpreparation.IFoodPreparationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPreparationControllerConfig {

    @Bean
    public IFoodPreparationController getFoodPreparationController(IFoodPreparationUseCase foodPreparationUseCase){
        return new FoodPreparationController(foodPreparationUseCase);
    }

    @Bean
    public IFinishingOfFoodPreparationController getFinishFoodController(IFinishingOfFoodPreparationUseCase finishingOfFoodPreparationUseCase){
        return new FinishingOfFoodPreparationController(finishingOfFoodPreparationUseCase);
    }
}
