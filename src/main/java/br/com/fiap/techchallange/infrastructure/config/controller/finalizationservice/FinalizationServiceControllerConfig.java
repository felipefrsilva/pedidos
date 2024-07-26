package br.com.fiap.techchallange.infrastructure.config.controller.finalizationservice;

import br.com.fiap.techchallange.adapters.controllers.orderpreparation.DeliveryOfProductsController;
import br.com.fiap.techchallange.adapters.controllers.orderpreparation.IDeliveryOfProductsController;
import br.com.fiap.techchallange.core.usecase.inputboundary.finalizationservice.IDeliveryOfProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizationServiceControllerConfig {

    @Bean
    public IDeliveryOfProductsController getDeliveryOfProductsController(IDeliveryOfProductsUseCase deliveryOfProductsUseCase){
        return new DeliveryOfProductsController(deliveryOfProductsUseCase);
    }
}
