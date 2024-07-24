package br.com.fiap.techchallange.infrastructure.config.usecase.finalizationservice;

import br.com.fiap.techchallange.core.usecase.finalizationservice.DeliveryOfProductsUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.finalizationservice.IDeliveryOfProductsUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizationServiceUserCaseConfig {

    @Bean
    public IDeliveryOfProductsUseCase getDeliveryOfProductsUseCase(IEventTrigger trigger){
        return new DeliveryOfProductsUseCase(trigger);
    }
}
