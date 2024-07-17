package br.com.fiap.techchallange.infrastructure.config.controller.ordercreation;

import br.com.fiap.techchallange.adapters.controllers.ordercreation.IProductsDisplayController;
import br.com.fiap.techchallange.adapters.controllers.ordercreation.ProductsDisplayController;
import br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation.IProductsDisplayUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderControllerConfig {

    @Bean
    public IProductsDisplayController getProducts(IProductsDisplayUseCase productsDisplayUseCase){
        return new ProductsDisplayController(productsDisplayUseCase);
    }
}
