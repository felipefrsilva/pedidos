package br.com.fiap.techchallange.infrastructure.config.usecase.orderpreparation;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpreparation.IFinishingOfFoodPreparationUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpreparation.IFoodPreparationUseCase;
import br.com.fiap.techchallange.core.usecase.orderpreparation.FinishingOfFoodPreparationUseCase;
import br.com.fiap.techchallange.core.usecase.orderpreparation.FoodPreparationUseCase;
import br.com.fiap.techchallange.core.usecase.tracking.IEventTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPreparationUseCaseConfig {

    @Bean
    public IFoodPreparationUseCase foodPreparationUseCase(IEventTrigger trigger){
        return new FoodPreparationUseCase(trigger);
    }

    @Bean
    public IFinishingOfFoodPreparationUseCase finishingOfFoodPreparationUseCase(IEventTrigger trigger){
        return new FinishingOfFoodPreparationUseCase(trigger);
    }
}
